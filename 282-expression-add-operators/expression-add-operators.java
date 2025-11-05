class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if(num.length()==0) return ans;
        helper(0, num, target, new StringBuilder(), 0, 0, ans);
        return ans;
    }
    private void helper(int ind, String num, int target, StringBuilder expr,
    long val, long prev, List<String> ans){
        if(ind==num.length()){
            if(val == target) ans.add(expr.toString());
            return;
        }
        for(int i=ind; i<num.length(); i++){
            if(i!=ind && num.charAt(ind)=='0') break;
            String curr = num.substring(ind, i+1);
            long currnum = Long.parseLong(curr);
            int lenprev = expr.length();
            if(ind==0){
                expr.append(curr);
                helper(i+1, num, target, expr, currnum, currnum, ans);
                expr.setLength(lenprev);
            }
            else {
                expr.append('+').append(curr);
                helper(i+1, num, target, expr, val+currnum, currnum, ans);
                expr.setLength(lenprev);

                expr.append('-').append(curr);
                helper(i+1, num, target, expr, val-currnum, -currnum, ans);
                expr.setLength(lenprev);

                expr.append('*').append(curr);
                helper(i+1, num, target, expr, val-prev+prev*currnum, prev*currnum, ans);
                expr.setLength(lenprev);
            }
        }
    }
}