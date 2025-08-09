class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int minsum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        for(int col=0; col<triangle.get(n-1).size(); col++){
            minsum = Math.min(minsum, helper(n-1, col, triangle, dp));
        }
        return minsum;
    }
    private int helper(int ind, int i, List<List<Integer>> triangle, int[][] dp){
        if(ind==0 && i==0) return triangle.get(0).get(0);
        if(i<0 || i>=triangle.get(ind).size()){
            return Integer.MAX_VALUE;
        }
        if(dp[ind][i] != -1) return dp[ind][i];
        int same = helper(ind-1, i, triangle, dp);
        int less = helper(ind-1, i-1, triangle, dp);
        return dp[ind][i] = triangle.get(ind).get(i) + Math.min(same, less);
    }
}