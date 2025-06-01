class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'T';
                q.add(new Pair(i, 0));
            }
            if(board[i][m-1] == 'O'){
                board[i][m-1] = 'T';
                q.add(new Pair(i, m-1));
            }
        }
        for(int i=0; i<m; i++){
            if(board[0][i] == 'O'){
                board[0][i] = 'T';
                q.add(new Pair(0, i));
            }
            if(board[n-1][i] == 'O'){
                board[n-1][i] = 'T';
                q.add(new Pair(n-1, i));
            }
        }
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                board[nrow][ncol]=='O'){
                    board[nrow][ncol] = 'T';
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}