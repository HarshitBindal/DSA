class Solution {
    public boolean parseBoolExpr(String expression) {
        int n = expression.length();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = expression.charAt(i);
            if(ch == ')'){
                ArrayList<Character> list = new ArrayList<>();
                while(st.peek() != '('){
                    list.add(st.pop());
                }
                st.pop(); // (
                char op = st.pop();
                char ans = evaluate(list, op);
                st.push(ans); // operator
            } else if(ch!=','){
                st.push(ch);
            }
        }
        return st.pop()=='f'? false: true;
    }
    private char evaluate(ArrayList<Character> list, char op){
        if(op == '&'){
            if(find(list, 'f')) return 'f';
            else return 't';
        } else if(op == '|'){
            if(find(list, 't')) return 't';
            else return 'f';
        } else {
            return list.get(0)=='f'? 't':'f';
        }
    }
    private boolean find(ArrayList<Character> list, char op){
        for(char ch: list){
            if(ch == op) return true;
        }
        return false;
    }
}