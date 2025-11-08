class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        int j=0;
        for(int i=0; i<n; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek()-'0'>ch-'0'){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(k>0) {
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)=='0'){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.length()==0? "0": sb.reverse().toString();
    }
}