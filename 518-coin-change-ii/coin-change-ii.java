class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(coins.length-1, amount, coins, dp);
    }
    private int helper(int i, int amt, int[] coins, int[][] dp){
        if(i<0 || amt < 0) return 0;
        if(amt == 0) return dp[i][amt] = 1;
        if(dp[i][amt] != -1) return dp[i][amt];
        int same = helper(i, amt-coins[i], coins, dp);
        int next = helper(i-1, amt, coins, dp);
        return dp[i][amt] = same + next;
    }
}