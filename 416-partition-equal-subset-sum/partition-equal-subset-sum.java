class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum%2 != 0) return false;
        int target = sum/2;
        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }
        if(nums[0]<=target) dp[0][nums[0]] = true;
        for(int i=1; i<dp.length; i++){
            for(int t=1; t<=target; t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(nums[i]<=t){
                    take = dp[i-1][t-nums[i]];
                }
                dp[i][t] = take || notTake;
            }
        }
        return dp[nums.length-1][target];
    }
    // private boolean helper(int ind, int target, int[] nums, int[][] dp){
    //     if(target==0) return true;
    //     if(ind==0) return nums[0]==target;
    //     if(target<0) return false;
    //     if(dp[ind][target] != -1) dp[ind][target] = 1;

    //     boolean take = helper(ind-1, target-nums[ind], nums, dp);
    //     boolean notTake = helper(ind-1, target, nums, dp);
    //     dp[ind][target] = (take || notTake) ? 1:0;
    //     return dp[ind][target] == 1;
    // }
}