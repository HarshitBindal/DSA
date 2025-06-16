class Solution {
    public int maximumDifference(int[] nums) {
        int result = -1;
        int i = 0, j = 1;
        while(j<nums.length){
            if(nums[i]>=nums[j]){
                i = j;
            } else {
                result = Math.max(result, nums[j]-nums[i]);
            }
            j++;
        }
        return result;
    }
}