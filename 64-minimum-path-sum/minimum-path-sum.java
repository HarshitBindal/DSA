class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) continue;
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = Math.min(up,left)+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
    // private int helper(int i, int j, int[][] grid, int[][] dp){
    //     if(i<0 || j<0) return Integer.MAX_VALUE;
    //     if(i==0 && j==0) return grid[0][0];
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up = helper(i-1, j, grid, dp);
    //     int left = helper(i, j-1, grid, dp);
    //     return dp[i][j] = Math.min(up, left)+grid[i][j];
    // }
}