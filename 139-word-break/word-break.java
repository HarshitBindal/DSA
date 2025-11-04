class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordDict.size(); i++){
            if(!set.contains(wordDict.get(i))) set.add(wordDict.get(i));
        }
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, s, set, dp);
    }
    private boolean helper(int i, String s, HashSet<String> set, Boolean[] dp){
        if(i==s.length()) return true;
        if(dp[i] != null) return dp[i];
        for(int end=i+1; end<=s.length(); end++){
            String word = s.substring(i, end);
            if(set.contains(word) && helper(end, s, set, dp)){
                dp[i]=true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }
}