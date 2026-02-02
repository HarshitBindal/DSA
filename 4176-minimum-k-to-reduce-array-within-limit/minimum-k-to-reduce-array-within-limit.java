class Solution {
    public int minimumK(int[] nums) {
        int n = nums.length;
        int left=1, right=100000;
        int ans = right;
        while(left<=right){
            int mid = left + (right-left)/2;
            int ops = 0;
            for(int num: nums){
                ops += (num+mid-1)/mid;
                if(ops>(long)mid*mid) break;
            }
            if(ops<=(long)mid*mid){
                ans = mid;
                right = mid-1;
            } else left = mid+1;
        }
        return ans;
    }
}