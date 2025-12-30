class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        int[] suffmin = new int[n];
        long[] prefix = new long[n];
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        suffmin[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffmin[i] = Math.min(suffmin[i+1], nums[i+1]);
        }
        long bestScore = Long.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            bestScore = Math.max(bestScore, prefix[i]-suffmin[i]);
        }
        return bestScore;
    }
}