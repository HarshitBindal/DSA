class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res);
        return res;
    }
    private void helper(int[] nums, int i, List<List<Integer>> res){
        if(i == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums) list.add(num);
            res.add(list);
            return;
        }
        for(int j=i; j<nums.length; j++){
            swap(nums, i, j);
            helper(nums, i+1, res);
            swap(nums, i, j);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}