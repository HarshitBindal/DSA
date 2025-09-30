class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        for(int[] row: dp){
            Arrays.fill(row, 0);
        }
        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                if(buy==1){
                    dp[i][buy] = Math.max(dp[i+1][0]-prices[i], dp[i+1][1]);
                } else {
                    dp[i][buy] = Math.max(dp[i+2][1]+prices[i], dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }
    private int helper(int ind, int buy, int[] prices, int[][] dp){
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        if(buy==1){
            return Math.max(helper(ind+1, 0, prices, dp)-prices[ind],
            helper(ind+1, 1, prices, dp));
        }
        else {
            return Math.max(helper(ind+2, 1, prices, dp)+prices[ind],
            helper(ind+1, 0, prices, dp));
        }
    }
}