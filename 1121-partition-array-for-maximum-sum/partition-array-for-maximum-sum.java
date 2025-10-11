class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return func(0, arr, k, dp);
    }
    private int func(int ind, int[] arr, int k, int[] dp){
        if(ind == arr.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        int maxAns = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE;
        int len = 0;
        for(int j=ind; j<Math.min(arr.length, ind+k); j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len*maxi) + func(j+1, arr, k, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }
}