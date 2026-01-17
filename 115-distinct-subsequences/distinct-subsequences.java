class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int j=0; j<=n; j++){
            dp[j][0]=1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int pick = 0;
                if(s.charAt(i-1)==t.charAt(j-1)) pick = dp[i-1][j-1];
                int notpick = dp[i-1][j];
                dp[i][j]=pick+notpick;
            }
        }
        return dp[n][m];
    }
    private int helper(int i, int j, String s, String t, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int pick = 0;
        if(s.charAt(i)==t.charAt(j)) pick = helper(i-1,j-1,s,t,dp);
        int notpick = helper(i-1,j,s,t,dp);
        return dp[i][j]=pick+notpick;
    }
}