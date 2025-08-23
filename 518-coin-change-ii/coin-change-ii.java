class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int j=coins[0]; j<=amount; j++){
            if(j%coins[0]==0) dp[0][j] = 1;
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<=amount; j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j-coins[i]>=0){
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][amount];
        // for(int[] row: dp){
        //     Arrays.fill(row, -1);
        // }
        // return helper(coins.length-1, amount, coins, dp);
    }
    // private int helper(int i, int amt, int[] coins, int[][] dp){
    //     if(i<0 || amt < 0) return 0;
    //     if(amt == 0) return dp[i][amt] = 1;
    //     if(dp[i][amt] != -1) return dp[i][amt];
    //     int same = helper(i, amt-coins[i], coins, dp);
    //     int next = helper(i-1, amt, coins, dp);
    //     return dp[i][amt] = same + next;
    // }
}