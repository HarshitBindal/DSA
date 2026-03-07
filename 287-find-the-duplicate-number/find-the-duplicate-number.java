class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            if(arr[nums[i]+1]==nums[i]) return nums[i];
            arr[nums[i]+1]=nums[i];
        }
        return -1;
    }
}