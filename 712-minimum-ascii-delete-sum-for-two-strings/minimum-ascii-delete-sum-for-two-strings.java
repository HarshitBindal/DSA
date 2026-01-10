class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+s1.charAt(i);
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        int total = 0;
        for(int i=0; i<n; i++){
            total += s1.charAt(i);
        }
        for(int i=0; i<m; i++){
            total += s2.charAt(i);
        }
        return total - 2*dp[0][0];
    }
}