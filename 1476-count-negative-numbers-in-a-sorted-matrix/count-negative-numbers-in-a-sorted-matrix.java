class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int[] curr: grid){
            int i = m-1;
            while(i>=0 && curr[i--]<0) ans++;
        }
        return ans;
    }
}