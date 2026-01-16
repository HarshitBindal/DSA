class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n][amount+1];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        int x = helper(n-1,coins,amount,dp);
        return x>=(int)1e9? -1:x;
    }
    private int helper(int ind, int[] coins, int amt, int[][] dp){
        if(ind==0){
            if(amt%coins[0]==0) return dp[ind][amt]=amt/coins[0];
            else return (int)1e9;
        }
        if(dp[ind][amt]!=-1) return dp[ind][amt];
        int take = (int)1e9;
        if(coins[ind]<=amt){
            take = 1+helper(ind,coins,amt-coins[ind],dp);
        }
        int notTake = helper(ind-1,coins,amt,dp);
        return dp[ind][amt] = Math.min(take, notTake);
    }
}