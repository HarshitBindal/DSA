class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0, j=n-1;
        int maxArea = 0;
        while(i<j){
            int mini = Math.min(height[i],height[j]);
            int water = (j-i)*mini;
            maxArea = Math.max(maxArea, water);
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}