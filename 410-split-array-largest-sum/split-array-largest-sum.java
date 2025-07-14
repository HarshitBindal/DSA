class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : nums) {
            high += num;
            low = Math.max(low, num);
        }
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(split(nums, k, mid)){
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }
    private boolean split(int[] nums, int k, int mid) {
        int curr = 0, count = 1;
        for (int num : nums) {
            if (curr + num > mid) {
                curr = num;
                count++;
                if(count>k) return false;
            } else {
                curr += num;
            }
        }
        return true;
    }
}