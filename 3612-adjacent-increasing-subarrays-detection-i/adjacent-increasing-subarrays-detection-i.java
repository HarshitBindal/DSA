class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int i=0;
        while(i+2*k<=n){
            if(isIncreasing(nums, i, k) && isIncreasing(nums, i+k, k)){
                return true;
            }
            else {
                i++;
            }
        }
        return false;
    }
    private boolean isIncreasing(List<Integer> nums, int start, int k){
        for(int i=start; i<start+k-1 && i+1<nums.size(); i++){
            if(nums.get(i)>=nums.get(i+1)) return false;
        }
        return true;
    }
}