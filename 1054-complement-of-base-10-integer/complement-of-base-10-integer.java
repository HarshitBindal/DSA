class Solution {
    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='1') sb.append('0');
            else sb.append('1');
        }
        String s = sb.toString();
        return Integer.parseInt(s, 2);
    }
}