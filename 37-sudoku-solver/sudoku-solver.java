class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    private boolean solve(char[][] board){
        int n = board.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isValid(ch, i, j, board)){
                            board[i][j] = ch;
                            if(solve(board)==true) return true;
                            else board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char ch, int row, int col, char[][] board){
        for(int i=0; i<9; i++){
            if(board[i][col]==ch) return false;
            if(board[row][i]==ch) return false;
            if(board[(row/3)*3 + i/3][(col/3)*3 + i%3]==ch) return false;
        }
        return true;
    }
}