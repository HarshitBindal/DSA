class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int pi = 0, ni = 1, k = 0;
        while(k<n){
            if(nums[k]>0){
                res[pi] = nums[k];
                pi += 2;
            } else{
                res[ni] = nums[k];
                ni += 2;
            }
            k++;
        }
        return res;
    }
}