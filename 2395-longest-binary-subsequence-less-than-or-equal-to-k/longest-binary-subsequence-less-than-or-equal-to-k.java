class Solution {
    public int longestSubsequence(String s, int k) {
        int zero = 0, one = 0, n = s.length();
        int pow = 1, value = 0;
        for(char ch: s.toCharArray()){
            if(ch == '0') zero++;
        }
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                if(Math.pow(2, n-i-1)+value <= k){
                    value += Math.pow(2, n-i-1);
                    one++;
                }
                pow = (int)Math.pow(2, n-i-1);
            }
            if(pow>k) break;
        }
        return one + zero;
    }
}