class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        for(int i=0; i<n; i++){
            if(board[i][0]=='O'){
                board[i][0]='T';
                q.offer(new int[]{i,0});
            }
            if(board[i][m-1]=='O'){
                board[i][m-1]='T';
                q.offer(new int[]{i,m-1});
            }
        }
        for(int i=0; i<m; i++){
            if(board[0][i]=='O'){
                board[0][i]='T';
                q.offer(new int[]{0,i});
            }
            if(board[n-1][i]=='O'){
                board[n-1][i]='T';
                q.offer(new int[]{n-1,i});
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int i=0; i<4; i++){
                int nr = curr[0]+drow[i];
                int nc = curr[1]+dcol[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='O'){
                    board[nr][nc]='T';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
}