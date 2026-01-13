class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return helper(cost, dp.length-1, dp);
    }
    private int helper(int[] cost, int ind, int[] dp){
        if(ind==0 || ind==1){
            return 0;
        }
        if(dp[ind]!=-1) return dp[ind];
        int left = helper(cost, ind-1, dp) + cost[ind-1];
        int right = Integer.MAX_VALUE;
        if(ind>1) right = helper(cost, ind-2, dp) + cost[ind-2];
        return dp[ind]=Math.min(left, right);
    }
}