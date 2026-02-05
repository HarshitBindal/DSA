class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int ind = (i+nums[i])%n;
            if(ind<0) ind+=n;
            result[i]=nums[ind];
        }
        return result;
    }
}