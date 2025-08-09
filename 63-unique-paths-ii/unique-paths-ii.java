class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return path(n-1, m-1, obstacleGrid, dp);

        // TABULATION METHOD // MORE OPTIMIZED //

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         if(obstacleGrid[i][j]==1) dp[i][j]=0;
        //         else if(i==0 && j==0) dp[i][j] = 1;
        //         else {
        //             if(i>0) int up = obstacleGrid[i-1][j];
        //             if(j>0) int left = obstacleGrid[i][j-1];
        //             dp[i][j] = up + left;
        //         }
        //     }
        // }
        // return dp[m-1][n-1];

    }
    private int path(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(i<0 || j<0) return 0;
        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = path(i-1, j, obstacleGrid, dp) + path(i, j-1, obstacleGrid, dp);
    }
}