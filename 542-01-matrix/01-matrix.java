class Pair{
    int i;
    int j;
    int s;
    public Pair(int i, int j, int s){
        this.i = i;
        this.j = j;
        this.s = s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visit = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        boolean[][] seen = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i, j, 0));
                    seen[i][j] = true;
                }
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek().i;
            int col = q.peek().j;
            int steps = q.peek().s;
            visit[row][col] = steps;
            q.poll();
            for(int k=0; k<4; k++){
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                !seen[nrow][ncol] && mat[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol, steps+1));
                    seen[nrow][ncol] = true;
                }
            }
        }
        return visit;
    }
}