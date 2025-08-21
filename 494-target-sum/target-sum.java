class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(0, target, nums);
    }
    private int helper(int ind, int tar, int[] nums){
        if(ind==nums.length){
            return tar==0? 1: 0;
        }
        int plus = helper(ind+1, tar-nums[ind], nums);
        int minus = helper(ind+1, tar+nums[ind], nums);
        return plus+minus;
    }
}