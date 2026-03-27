class Solution {
    public long rob(int[] nums, int[] colors) {
        long left = 0;
        long right = nums[0];
        long next = right;
        for(int i=1; i<nums.length; i++){
            if(colors[i]==colors[i-1]){
                next = Math.max(right, left+nums[i]);
            } else {
                next = right+nums[i];
            }
            left = right;
            right = next;
        }
        return next;
    }
}