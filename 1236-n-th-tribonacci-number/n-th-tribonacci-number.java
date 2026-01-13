class Solution {
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    private int helper(int n, int[] dp){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        int one = helper(n-1, dp);
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        if(n>1) two = helper(n-2,dp);
        if(n>2) three = helper(n-3,dp);
        return dp[n]= one+two+three;
    }
}