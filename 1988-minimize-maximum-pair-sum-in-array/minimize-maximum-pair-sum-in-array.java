class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i=0, j=n-1;
        int maxi = -1;
        while(i<j){
            maxi = Math.max(maxi, nums[i]+nums[j]);
            i++;
            j--;
        }
        return maxi;
    }
}