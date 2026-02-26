class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        int len = s.length();
        char last = s.charAt(len-1);
        int i=len-2;
        while(i>=0){
            if(s.charAt(i)==last) return false;
            last = s.charAt(i);
            i--;
        }
        return true;
    }
}