class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totsum = 0;
        for(int num: nums) totsum += num;
        if(totsum-target<0 || (totsum-target)%2 != 0) return 0;
        return helper((totsum-target)/2, nums);
    }
    private int helper(int tar, int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][tar+1];
        if(nums[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;
        if(nums[0]!=0 && nums[0]<=tar){
            dp[0][nums[0]] = 1;
        }
        for(int i=1; i<n; i++){
            for(int sum=0; sum<=tar; sum++){
                int notTake = dp[i-1][sum];
                int take = 0;
                if(nums[i]<=sum) take = dp[i-1][sum-nums[i]];
                dp[i][sum] = notTake + take;
            }
        }
        return dp[n-1][tar];
    }
}