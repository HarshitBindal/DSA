class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2 = reverse(s);
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    private String reverse(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        for(int i=0; i<n/2; i++){
            char temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        StringBuilder sb = new StringBuilder("");
        for(char ch: arr){
            sb.append(ch);
        }
        return sb.toString();
    }
}