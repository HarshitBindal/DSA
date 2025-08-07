class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int max1 = func(Arrays.copyOfRange(nums, 1, n));
        int max2 = func(Arrays.copyOfRange(nums, 0, n-1));
        return Math.max(max1, max2);
    }
    private int func(int[] nums){
        int n = nums.length;
        int prev = nums[0];
        int prev2 = 0;
        for(int i=1; i<n; i++){
            int take = nums[i] + prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}