class Solution {
    public String shortestPalindrome(String s) {
        if(s==null || s.length()<=1) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String str = s + "#" + rev;
        int[] lps = createlps(str);
        int l = lps[lps.length-1];
        String suffix = s.substring(l);
        String toAdd = new StringBuilder(suffix).reverse().toString();
        return toAdd + s;
    }
    private int[] createlps(String s){
        int n = s.length();
        int len = 0, i=1;
        int[] lps = new int[n];
        lps[0] = 0;
        while(i<n){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0){
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}