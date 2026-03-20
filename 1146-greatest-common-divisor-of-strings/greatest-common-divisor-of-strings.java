class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int n = str2.length();
        if(!(str1+str2).equals(str2+str1)) return "";
        int len = gcd(str1.length(), str2.length());
        return str1.substring(0,len);
    }
    private int gcd(int x, int y){
        while(y!=0){
            int temp = x%y;
            x=y;
            y=temp;
        }
        return x;
    }
}