class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordDict){
            if(!set.contains(word)) set.add(word);
        }
        Boolean[] dp = new Boolean[s.length()];
        return helper(s,0,set,dp);
    }
    private boolean helper(String s, int ind, HashSet<String> set, Boolean[] dp){
        if(ind==s.length()) return true;
        if(dp[ind]!=null) return dp[ind];
        for(int end=ind+1; end<=s.length(); end++){
            String str = s.substring(ind, end);
            if(set.contains(str) && helper(s,end,set,dp)) {
                return dp[ind]=true;
                // return true;
            }
        }
        return dp[ind]=false;
        // return false;
    }
}