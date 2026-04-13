class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] res = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                } 
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            res[curr[0]][curr[1]] = curr[2];
            for(int i=0; i<4; i++){
                int nr = drow[i]+curr[0];
                int nc = dcol[i]+curr[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc] && mat[nr][nc]==1){
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr,nc,curr[2]+1});
                }
            }
        }
        return res;
    }
}