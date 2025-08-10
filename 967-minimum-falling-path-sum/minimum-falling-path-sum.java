class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }
        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
                int up = matrix[i][j] + dp[i-1][j];

                int ld = matrix[i][j];
                if(j>0) ld += dp[i-1][j-1];
                else ld = Integer.MAX_VALUE;
                
                int rd = matrix[i][j];
                if(j+1<n) rd += dp[i-1][j+1];
                else rd = Integer.MAX_VALUE;
                
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        int mini = dp[n-1][0];
        for(int j=0; j<n; j++){
            mini = Math.min(mini, dp[n-1][j]);
        }
        return mini;
    }
}