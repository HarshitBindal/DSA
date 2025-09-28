class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int peri = 0;
        for(int i=0; i<n-2; i++){
            if(isTriangle(nums[i], nums[i+1], nums[i+2])){
                peri = Math.max(peri, nums[i]+nums[i+1]+nums[i+2]);
            }
        }
        return peri;
    }
    private boolean isTriangle(int x, int y, int z){
        if(x+y>z && x+z>y && y+z>x){
            return true;
        }
        return false;
    }
}