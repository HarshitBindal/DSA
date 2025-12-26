class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islands = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    private void bfs(char[][] grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        grid[r][c] = '0';
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++){
                int nrow = drow[i]+row;
                int ncol = dcol[i]+col;
                if(nrow>=0 && nrow<n && ncol<m && ncol>=0 && 
                grid[nrow][ncol]=='1'){
                    q.offer(new int[]{nrow, ncol});
                    grid[nrow][ncol]='0';
                }
            }
        }
    }
}