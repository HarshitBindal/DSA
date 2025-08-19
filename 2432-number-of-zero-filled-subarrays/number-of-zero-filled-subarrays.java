class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long count =0;
        long streak =0;

        for(int num:nums){
            if(num==0){
                count++;
                streak+=count;
            }
            else{
                count =0;
            }
        }
        return streak;
    }
}