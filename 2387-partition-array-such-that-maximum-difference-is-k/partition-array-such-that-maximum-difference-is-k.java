class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int start = 0;
        int i = 0;
        while(i<nums.length){
            if(nums[i]-nums[start]>k){
                count++;
                start = i;
            }
            i++;
        }
        return count;
    }
}