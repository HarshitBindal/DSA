class Solution {
    public int sumOfGoodNumbers(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            if(i<k){
                if(nums[i]>nums[i+k]) sum += nums[i]; 
            }
            if(i>=nums.length-k){
                if(nums[i]>nums[i-k]) sum += nums[i]; 
            }
            if(i>=k && i<nums.length-k){
                if(nums[i]>nums[i-k] && nums[i]>nums[i+k]) sum += nums[i];
            }
        }
        // for(int i=0; i<k; i++){
        //     if(nums[i]>nums[i+k]) sum += nums[i];
        // }
        // for(int i=k; i<nums.length-k; i++){
        //     if(nums[i]>nums[i+k] && nums[i]>nums[i-k]) sum += nums[i];
        // }
        // for(int i=k+1; i<nums.length; i++){
        //     if(nums[i]>nums[i-k]) sum += nums[i];
        // }
        return sum;
    }
}