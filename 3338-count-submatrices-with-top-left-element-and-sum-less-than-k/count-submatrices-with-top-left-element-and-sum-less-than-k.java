class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        if(k<grid[0][0]) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n+1][m+1];
        int cnt=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1]+grid[i-1][j-1]-arr[i-1][j-1];
                if(arr[i][j]<=k) cnt++;
            }
        }
        return cnt;
    }
}