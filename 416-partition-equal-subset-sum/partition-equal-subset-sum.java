class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums) sum+=num;
        if(sum%2!=0) return false;
        Boolean[][] dp = new Boolean[n][sum/2 + 1];
        return helper(n-1, sum/2, nums, dp);
    }
    private boolean helper(int ind, int target, int[] nums, Boolean[][] dp){
        if(target==0) return true;
        if(ind<0 || target<0) return false;
        if(ind==0) return nums[ind]==target;
        if(dp[ind][target]!=null) return dp[ind][target];
        boolean take = helper(ind-1, target-nums[ind], nums, dp);
        boolean notTake = helper(ind-1, target, nums, dp);
        return dp[ind][target]=take||notTake;
    }
}