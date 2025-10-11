class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return func(0, s, dp)-1;
    }
    private int func(int ind, String s, int[] dp){
        if(ind==s.length()) return 0;
        if(dp[ind] != -1) return dp[ind];
        int minCost = Integer.MAX_VALUE;
        for(int j=ind; j<s.length(); j++){
            if(isPalindrome(ind, j, s)){
                int cost = 1+ func(j+1, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[ind] = minCost;
    }
    private boolean isPalindrome(int i, int j, String temp){
        while(i<j){
            if(temp.charAt(i) != temp.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}