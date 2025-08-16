class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        int x = helper(coins.length-1, coins, amount, dp);
        return x >= (int)1e9? -1: x;
    }
    private int helper(int ind, int[] coins, int sum, int[][] dp){
        if(ind==0){
            if(sum%coins[ind] == 0) dp[ind][sum] = sum/coins[ind];
            else return dp[ind][sum] = (int)1e9;
        }
        if(dp[ind][sum] != -1) return dp[ind][sum];
        int notTake = helper(ind-1, coins, sum, dp);
        int take = (int)1e9;
        if(coins[ind]<=sum){
            take = 1+helper(ind, coins, sum-coins[ind], dp);
        } 
        return dp[ind][sum] = Math.min(notTake, take);
    }
}