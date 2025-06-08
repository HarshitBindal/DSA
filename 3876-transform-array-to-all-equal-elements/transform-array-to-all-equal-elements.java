class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        return check(nums.clone(), k, 1) || check(nums.clone(), k, -1);
    }
    private boolean check(int[] nums, int k, int x) {
        int n = nums.length;
        for (int i = 0; i < n - 1 && k > 0; i++) {
            if (nums[i] != x) {
                nums[i] = x;
                nums[i + 1] *= -1;
                k--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != x) return false;
        }
        return true;
    }
}