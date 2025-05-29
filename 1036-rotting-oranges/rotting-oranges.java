class Pair {
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visit = new int[n][m];
        int cntfresh = 0;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    visit[i][j] = 2;
                } else if(grid[i][j] == 0){
                    visit[i][j] = 0;
                } else {
                    visit[i][j] = 1;
                    cntfresh++;
                }
            }
        }

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        int cnt = 0;
        int tm = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            q.poll();
            for(int i=0; i<4; i++){
                int nrow = r + deltaRow[i];
                int ncol = c + deltaCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                visit[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    visit[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol, t+1));
                    cnt++;
                }
            }
            tm = Math.max(tm, t);
        }
        if(cnt != cntfresh) return -1;
        return tm;
    }
}