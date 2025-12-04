class Solution {
    public int countCollisions(String directions) {
        Stack<Character> st = new Stack<>();
        int collision = 0;
        int n = directions.length();
        st.push(directions.charAt(0));
        for(int i=1; i<n; i++){
            char ch = directions.charAt(i);
            if(st.peek()=='R' && ch=='L'){
                collision += 2;
                st.pop();
                while(!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    collision++;
                }
                st.push('S');
            }
            else if(st.peek()=='R' && ch=='S'){
                collision ++;
                st.pop();
                while(!st.isEmpty() && st.peek()=='R'){
                    st.pop();
                    collision++;
                }
                st.push('S');
            }
            else if(st.peek()=='S' && ch=='L'){
                collision++;
            }
            else st.push(ch);
        }
        return collision;
    }
}