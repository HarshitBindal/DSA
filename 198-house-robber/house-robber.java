class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        return helper(n-1, nums, dp);
    }
    private int helper(int ind, int[] nums, int[] dp){
        if(ind<0) return 0;
        if(ind == 0) return nums[0];
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] + helper(ind-2, nums, dp);
        int notpick = 0 + helper(ind-1, nums, dp);
        return dp[ind] = Math.max(pick, notpick);
    }
}