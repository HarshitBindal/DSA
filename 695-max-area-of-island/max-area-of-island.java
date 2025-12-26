class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxi = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    grid[i][j]=0; //mark it visited
                    maxi = Math.max(maxi, bfs(grid, i, j));
                }
            }
        }
        return maxi;
    }
    private int bfs(int[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        int size = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int nrow = drow[i]+row;
                int ncol = dcol[i]+col;
                if(nrow>=0 && nrow<n && ncol<m && ncol>=0 && 
                grid[nrow][ncol]==1){
                    q.offer(new int[]{nrow, ncol});
                    size++;
                    grid[nrow][ncol]=0;
                }
            }
        }
        return size;
    }
}