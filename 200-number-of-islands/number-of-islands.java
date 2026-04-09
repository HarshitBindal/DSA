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
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0; i<4; i++){
                int nrow = curr[0]+drow[i];
                int ncol = curr[1]+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1'){
                    q.offer(new int[]{nrow, ncol});
                    grid[nrow][ncol]='0';
                }
            }
        }
    }
}