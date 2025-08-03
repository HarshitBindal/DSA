class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int n=candidates.length;
        Arrays.sort(candidates);
        helper(res, set, candidates, 0, target, 0, n);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> set, int[] candidates,
    int sum, int target, int i, int n){
        if(sum==target){
            res.add(new ArrayList<>(set));
            return;
        }
        for(int j=i; j<n; j++){
            if(j>i && candidates[j]==candidates[j-1]) continue;
            if(sum+candidates[j] > target) break;
            set.add(candidates[j]);
            helper(res, set, candidates, sum+candidates[j], target, j+1,  n);
            set.remove(set.size()-1);

        }
    }
}