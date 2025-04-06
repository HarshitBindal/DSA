class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    private int helper(int[] nums, int idx, int currxor){
        if(idx == nums.length){
            return currxor;
        }
        return helper(nums, idx+1, currxor ^ nums[idx]) + helper(nums, idx+1, currxor);
    }
}