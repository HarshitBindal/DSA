class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        for(int i=0; i<n; i++){
            if(grid[i][0]==1){
                q.add(new int[]{i, 0});
                grid[i][0] = 2;
            }
            if(grid[i][m-1]==1){
                q.add(new int[]{i, m-1});
                grid[i][m-1] = 2;
            }
        }
        for(int i=0; i<m; i++){
            if(grid[0][i]==1){
                q.add(new int[]{0, i});
                grid[0][i] = 2;
            }
            if(grid[n-1][i]==1){
                q.add(new int[]{n-1, i});
                grid[n-1][i] = 2;
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0; i<4; i++){
                int nrow = curr[0] + drow[i];
                int ncol = curr[1] + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                grid[nrow][ncol]==1){
                    grid[nrow][ncol] = 2;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
}