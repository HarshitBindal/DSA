class Solution {
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp = new int[n][n];
        for(int[] curr: dp){
            Arrays.fill(curr,-1);
        }
        return helper(n-1,n-1,s,rev,dp);
    }
    private int helper(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=1+helper(i-1,j-1,s1,s2,dp);
        return dp[i][j] = Math.max(helper(i,j-1,s1,s2,dp), helper(i-1,j,s1,s2,dp));
    }
}