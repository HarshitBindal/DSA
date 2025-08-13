class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int mask = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(i != nums[i]){
                mask = mask & nums[i];
            }
        }
        return mask == Integer.MAX_VALUE? 0: mask;
    }
}