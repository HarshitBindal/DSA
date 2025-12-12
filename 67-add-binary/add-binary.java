class Solution {
    public String addBinary(String a, String b) {
        int n = a.length()-1;
        int m = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(n>=0 || m>=0 || carry==1){
            int A = (n>=0)? a.charAt(n)-'0': 0;
            int B = (m>=0)? b.charAt(m)-'0': 0;
            int sum = A + B + carry;
            sb.append(sum%2);
            carry = sum/2;
            n--;
            m--;
        }
        return sb.reverse().toString();
    }
}