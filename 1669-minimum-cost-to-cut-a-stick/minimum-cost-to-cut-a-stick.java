class Solution {
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        int m = arr.length;
        for(int i=0; i<m-2; i++){
            arr[i] = cuts[i];
        }
        arr[m-2] = 0;
        arr[m-1] = n;
        Arrays.sort(arr);
        int[][] dp = new int[m][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return func(1, m-2, arr, dp);
    }
    private int func(int i, int j, int[] arr, int[][] dp){
        if(i>j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind=i; ind<=j; ind++){
            int cost = arr[j+1]-arr[i-1] + func(i,ind-1,arr,dp) + func(ind+1,j,arr,dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
}