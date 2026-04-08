class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = (int)(1e9+7);
        int n = nums.length;
        for(int[] query: queries){
            for(int i=query[0]; i<=query[1]; i+=query[2]){
                nums[i] = (int)((1L*nums[i]*query[3])%mod);
            }
        }
        int res = 0;
        for(int num : nums){
            res = res ^ num;
        }
        return res;
    }
}