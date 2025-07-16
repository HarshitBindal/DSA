class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            sum = nums[i];
            if(nums[i]==goal){
                count++;
            }
            int j=i+1;
            while(j<n){
                sum += nums[j];
                if(sum == goal) {
                    count++;
                } else if(sum>goal){
                    sum = 0;
                    break;
                }
                j++;
            }
        }
        return count;
    }
}