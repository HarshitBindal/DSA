class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(0, -1, nums, dp);
    }
    private int helper(int ind, int prev, int[] nums, int[][] dp){
        if(ind == nums.length) return 0;
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        int len = helper(ind+1, prev, nums, dp);
        if(prev == -1 || nums[ind]>nums[prev]){
            len = Math.max(len, 1+helper(ind+1, ind, nums, dp));
        }
        return dp[ind][prev+1] = len;
    }
}