class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0) return -1;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});

        int drow[] = {-1, -1, -1, 0, 1, 1, 1, 0};
        int dcol[] = {-1, 0, 1, 1, 1, 0, -1, -1};
        // int dist = -1;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0]==n-1 && curr[1]==m-1) return curr[2];
            int dist = curr[2];
            for(int i=0; i<8; i++){
                int nrow = drow[i] + curr[0];
                int ncol = dcol[i] + curr[1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                visited[nrow][ncol]==false && grid[nrow][ncol]==0){
                    q.offer(new int[]{nrow, ncol, dist+1});
                    visited[nrow][ncol] = true;
                }
            }
        }
        return -1;
    }
}