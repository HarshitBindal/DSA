class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    private int helper(String s, int ind, int[] dp){
        if(ind==s.length()) return 1;
        if(s.charAt(ind)=='0') return 0;
        if(dp[ind]!=-1) return dp[ind];
        int res = helper(s, ind+1, dp);
        if(ind<s.length()-1){
            if(s.charAt(ind)=='1' || (s.charAt(ind)=='2' && s.charAt(ind+1)<'7')){
                res += helper(s, ind+2, dp);
            }
        }
        return dp[ind]=res;
    }
}