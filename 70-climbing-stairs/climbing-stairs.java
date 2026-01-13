class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n,dp);
    }
    private int helper(int n, int[] dp){
        if(n==1 || n==0) return 1;
        if(dp[n]!=-1) return dp[n];
        int one = helper(n-1, dp);
        int two = Integer.MAX_VALUE;
        two = helper(n-2, dp);
        return dp[n]= one+two;
    }
}