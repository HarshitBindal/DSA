class Solution {
    public int minimumPrefixLength(int[] nums) {
        int i=0, j=0;
        int n = nums.length;
        if(n==1) return 0;
        while(j+1<n){
            if(nums[j]>=nums[j+1]) i=j+1;
            j++;
        }
        return n-(j-i+1);
    }
}