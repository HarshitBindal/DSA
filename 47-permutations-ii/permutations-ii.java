class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        helper(0, nums, res, set);
        return res;
    }
    private void helper(int i, int[] nums, List<List<Integer>> res, HashSet<List<Integer>> set){
        if(i==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums) list.add(num);
            if(!set.contains(list)) res.add(list);
            set.add(list);
            return;
        }
        for(int j=i; j<nums.length; j++){
            swap(i, j, nums);
            helper(i+1, nums, res, set);
            swap(i, j, nums);
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}