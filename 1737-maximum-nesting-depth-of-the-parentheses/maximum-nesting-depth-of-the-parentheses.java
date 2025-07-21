class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxi = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(ch);
                depth++;
            } else if(ch == ')'){
                st.pop();
                maxi = Math.max(depth, maxi);
                depth--;
            }
        }
        return maxi;
    }
}