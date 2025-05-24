class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = maxElement(nums);
        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int sum = result(nums, mid);
            if(sum<=threshold){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private int result(int[] nums, int div){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += Math.ceil((double)nums[i]/div);
        }
        return sum;
    }
    private int maxElement(int[] nums){
        int x = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            x = Math.max(x, nums[i]);
        }
        return x;
    }
}