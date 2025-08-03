class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int n=candidates.length;
        helper(res, set, candidates, 0, target, 0, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> set, int[] candidates,
    int sum, int target, int i, int n){
        if(sum>target || i>=n){
            return;
        }
        if(sum==target){
            res.add(new ArrayList<>(set));
            return;
        }

        set.add(candidates[i]);
        sum += candidates[i];
        helper(res, set, candidates, sum, target, i, n);
        set.remove(set.size()-1);
        sum -= candidates[i];

        helper(res, set, candidates, sum, target, i+1, n);

    }
}