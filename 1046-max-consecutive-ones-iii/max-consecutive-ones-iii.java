class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0, j=0;
        int n = nums.length;
        int count = 0;
        int maxLen = 0;
        while(j<n){
            if(nums[j]==0){
                count++;
            }
            while(count>k){
                if(nums[i]==0) count--;
                i++;
            }
            maxLen = Math.max(j-i+1, maxLen);
            j++;
        }
        return maxLen;
    }
}