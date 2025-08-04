class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> hash = new HashSet<>();
        int n = nums.length;
        helper(res, set, nums, 0, n, hash);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> set, int[] nums, 
    int i, int n, HashSet<List<Integer>> hash){
        if(i>=n) return;
        set.add(nums[i]);
        helper(res, set, nums, i+1, n, hash);
        if(!hash.contains(set)) {
            hash.add(new ArrayList<>(set));
            res.add(new ArrayList<>(set));
        }
        set.remove(set.size()-1);
        helper(res, set, nums, i+1, n, hash);
        if(!hash.contains(set)) {
            hash.add(new ArrayList<>(set));
            res.add(new ArrayList<>(set));
        }
    }
}