class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, ans, "", n);
        return ans;
    }
    private void helper(int open, int close, List<String> ans, String s, int n){
        if(open == close && (open + close == 2*n)){
            ans.add(s);
            return;
        }
        if(open < n){
            helper(open+1, close, ans, s+"(", n);
        }
        if(close < open){
            helper(open, close+1, ans, s+")", n);
        }
    }
}