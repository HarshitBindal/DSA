class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        if(n==1) return 0;
        char[] color = colors.toCharArray();
        int left = 0;
        int right = 0;
        int time = 0;
        int maxi = 0;
        while(right<n){
            while(right<n && color[right]==color[left]){
                time += neededTime[right];
                maxi = Math.max(maxi, neededTime[right]);
                right++;
            }
            time -= maxi;
            maxi = 0;
            left = right;
        }
        return time;
    }
}