class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(0, 1, prices, fee, dp);
    }
    private int helper(int ind, int buy, int[] prices, int fee, int[][] dp){
        if(ind==prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy == 1){
            return dp[ind][buy] = Math.max(helper(ind+1, 0, prices, fee, dp)-prices[ind],
            helper(ind+1, 1, prices, fee, dp));
        }
        else {
            return dp[ind][buy] = Math.max(helper(ind+1, 1, prices, fee, dp)+prices[ind]-fee,
            helper(ind+1, 0, prices, fee, dp));
        }
    }
}