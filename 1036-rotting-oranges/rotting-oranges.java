class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int rotten = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) rotten++;
            }
        }
        // if(rotten==0) return -1;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2) {
                    q.offer(new int[]{i,j,0});
                    // break;
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int time = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0; i<4; i++){
                int nrow = curr[0]+drow[i];
                int ncol = curr[1]+dcol[i];
                int tm = curr[2];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    q.offer(new int[]{nrow,ncol,tm+1});
                    grid[nrow][ncol]=2;
                    fresh--;
                    time=tm+1;
                }
            }
        }
        if(fresh!=0) return -1;
        return time;
    }
}