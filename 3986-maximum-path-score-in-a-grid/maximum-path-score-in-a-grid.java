class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m][k+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = helper(n-1,m-1,grid,k);
        return res<0? -1: res;
    }
    public int[][][] dp;
    private int helper(int i, int j, int[][] grid, int cost){
        if(cost<0) return -100000;
        int currcost = (grid[i][j]==0)? 0:1;
        int currscore = grid[i][j];
        if(cost<currcost) return -100000;
        if(i==0 && j==0) return 0;
        if(dp[i][j][cost]!=-1) return dp[i][j][cost];
        int best = -100000;
        if(i>0){
            best = Math.max(best, helper(i-1,j,grid,cost-currcost));
        }
        if(j>0){
            best = Math.max(best, helper(i,j-1,grid,cost-currcost));
        }
        return dp[i][j][cost] = best+currscore;
    }
}