class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = Math.abs(nums[n-1]-nums[0]);
        for(int i=0; i<n-1; i++){
            diff = Math.max(diff, Math.abs(nums[i+1]-nums[i]));
        }
        return diff;
    }
}