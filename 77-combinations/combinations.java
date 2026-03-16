class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, res, new ArrayList<>(), n, k);
        return res;
    }
    private void helper(int start, List<List<Integer>> res, List<Integer> temp, int n,
    int k){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++){
            temp.add(i);
            helper(i+1, res, temp, n, k);
            temp.remove(temp.size()-1);
        }
    }
}