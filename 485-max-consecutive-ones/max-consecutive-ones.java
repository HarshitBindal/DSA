class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        int count = 0;
        if(nums[0]==1){
            count = 1;
            maxi = 1;
        } 
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i]==1) count++;
            maxi = Math.max(maxi, count);
            if(nums[i]==0) count = 0;
        }
        return maxi;
    }
}