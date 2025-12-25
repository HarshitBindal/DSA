class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int cntfresh = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit[i][j] = grid[i][j];
                if(grid[i][j]==1){
                    cntfresh++;
                } else if(grid[i][j]==2) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int cnt = 0, tm = 0;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            q.poll();
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==1 
                && grid[nrow][ncol]==1){
                    q.offer(new int[]{nrow, ncol, t+1});
                    cnt++;
                    visit[nrow][ncol] = 2;
                }
            }
            tm = Math.max(tm, t);
        }
        return cnt!=cntfresh? -1: tm;
    }
}