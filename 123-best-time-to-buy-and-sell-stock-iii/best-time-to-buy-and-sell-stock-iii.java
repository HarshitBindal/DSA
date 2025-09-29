class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] arr: dp){
            for(int[] row: arr){
                Arrays.fill(row, -1);
            }
        }
        return helper(0, 1, 2, prices, dp);
    }
    private int helper(int ind, int buy, int cap, int[] prices, int[][][] dp){
        if(cap == 0) return 0;
        if(ind == prices.length) return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];
        if(buy==1){
            return dp[ind][buy][cap]=Math.max(-prices[ind]+helper(ind+1, 0, cap, prices,dp),
            helper(ind+1, 1, cap, prices,dp));
        }
        else {
            return dp[ind][buy][cap]=Math.max(prices[ind]+helper(ind+1, 1, cap-1, prices,dp),
            helper(ind+1, 0, cap, prices,dp));
        }
    }
}