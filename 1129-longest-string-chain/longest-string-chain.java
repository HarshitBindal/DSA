class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)-> Integer.compare(a.length(),b.length()));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(dp[prev]+1>dp[i] && possible(words[prev],words[i])){
                    dp[i] = dp[prev]+1;
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
            }
        }
        return maxi;
    }
    private boolean possible(String str1, String str2){
        if(str1.length()+1 != str2.length()) return false;
        int first = 0;
        int second = 0;
        while(first<str1.length() && second<str2.length()){
            if(str1.charAt(first)==str2.charAt(second)){
                first++;
                second++;
            }
            else {
                second++;
            }
        }
        return first == str1.length();
    }
}