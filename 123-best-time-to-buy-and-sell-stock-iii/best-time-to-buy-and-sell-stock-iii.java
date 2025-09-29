class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for(int[][] arr: dp){
            for(int[] row: arr){
                Arrays.fill(row, 0);
            }
        }
        for(int i=prices.length-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=2; cap++){
                    if(buy==1){
                        dp[i][buy][cap] = Math.max(dp[i+1][0][cap]-prices[i],
                        dp[i+1][1][cap]);
                    } else {
                        dp[i][buy][cap] = Math.max(dp[i+1][1][cap-1]+prices[i],
                        dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}