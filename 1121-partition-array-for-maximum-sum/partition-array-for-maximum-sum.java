class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        for(int ind=n-1; ind>=0; ind--){
            int maxAns = Integer.MIN_VALUE;
            int maxi = Integer.MIN_VALUE;
            int len = 0;
            for(int j=ind; j<Math.min(arr.length, ind+k); j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len*maxi) + dp[j+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }
}