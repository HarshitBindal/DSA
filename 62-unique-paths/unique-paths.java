class Solution {
    public int uniquePaths(int m, int n) {
        int path = 0;
        int[][] dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, path, dp);
        
    }
    private int helper(int m, int n, int path, int[][] dp){
        if(m<0 || n<0) return 0;
        if(m==0 && n==0){
            return 1;
        }
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = helper(m-1, n, path++, dp) + helper(m, n-1, path++, dp);
        
    }
}