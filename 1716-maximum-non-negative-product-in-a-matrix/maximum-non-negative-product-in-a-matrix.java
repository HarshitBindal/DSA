class Solution {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long mod = 1000000007L;
        Long[][][] dp = new Long[n][m][2];
        long[] arr = helper(n-1, m-1, dp, grid);
        if(arr[0]<0) return -1;
        return (int)(arr[0]%mod);
    }
    private long[] helper(int i, int j, Long[][][] dp, int[][] grid){
        if(i==0 && j==0) return new long[]{grid[0][0], grid[0][0]};
        if(dp[i][j][0]!=null) return new long[]{dp[i][j][0], dp[i][j][1]};
        long maxval = Long.MIN_VALUE;
        long minval = Long.MAX_VALUE;
        int val = grid[i][j];
        if(i>0){
            long[] top = helper(i-1, j, dp, grid);
            long a = top[0]*val;
            long b = top[1]*val;
            maxval = Math.max(maxval,  Math.max(a,b));
            minval = Math.min(minval, Math.min(a,b));
        }
        if(j>0){
            long[] left = helper(i, j-1, dp, grid);
            long a = left[0]*val;
            long b = left[1]*val;
            maxval = Math.max(maxval, Math.max(a,b));
            minval = Math.min(minval, Math.min(a,b));
        }
        dp[i][j][0] = maxval;
        dp[i][j][1] = minval;
        return new long[]{maxval, minval};
    }
}