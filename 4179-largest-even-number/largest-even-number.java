class Solution {
    public String largestEven(String s) {
        int n = s.length();
        if(s.charAt(n-1)=='2') return s;
        String str = s.substring(0,n-1);
        while(str.length()>0 && str.charAt(str.length()-1)=='1'){
            str = str.substring(0, str.length()-1);
        }
        return str;
    }
}