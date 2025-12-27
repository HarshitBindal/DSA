class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][m];
        int[][] visit = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    seen[i][j] = true;
                } 
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int steps = q.peek()[2];
            visit[r][c] = steps;
            q.poll();
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                !seen[nrow][ncol] && mat[nrow][ncol]!=0){
                    seen[nrow][ncol] = true;
                    q.offer(new int[]{nrow, ncol, steps+1});
                }
            }
        }
        return visit;
    }
}