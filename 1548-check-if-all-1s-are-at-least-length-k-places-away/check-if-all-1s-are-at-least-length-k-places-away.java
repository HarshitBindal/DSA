class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int ind = -(n*2);
        // int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i]==1){
                // count++;
                if(i-ind<=k) return false;
                else ind = i;
            }
        }
        return true;
    }
}