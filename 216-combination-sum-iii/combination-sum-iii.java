class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        int[] nums = new int[9];
        for(int i=0; i<9; i++){
            nums[i] = i+1;
        }
        helper(res, set, nums, 0, 0, k, n, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> set, int[] nums,
    int sum, int i, int k, int n, int size){

        if(sum>n) return;
        if(sum == n && size == k) {
            res.add(new ArrayList<>(set));
            return;
        }
        for(int j=i; j<9; j++){
            set.add(nums[j]);
            helper(res, set, nums, sum+nums[j], j+1, k, n, size+1);
            set.remove(set.size()-1);
        }
    }
}