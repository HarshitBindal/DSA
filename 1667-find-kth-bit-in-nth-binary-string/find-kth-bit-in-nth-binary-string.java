class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1; i<n; i++){
            String s = sb.toString();
            sb.append('1');
            StringBuilder curr = new StringBuilder("");
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)=='1') curr.append('0');
                else curr.append('1');
            }
            sb.append(curr.reverse());
        }
        return sb.charAt(k-1);
    }
}