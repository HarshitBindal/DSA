class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> st = new Stack<>();
        int n = str.length();
        int i=0;
        while(i<n/2){
            st.push(str.charAt(i));
            i++;
        }
        if(n%2 != 0) i++;
        while(!st.isEmpty()){
            if(str.charAt(i) != st.peek()){
                return false;
            }
            st.pop();
            i++;
        }
        return true;
    }
}