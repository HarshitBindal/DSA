class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(word.charAt(0) == board[i][j]){
                    if(find(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean find(char[][] board, String word, int r, int c, int k){
        if(k == word.length()) return true;
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c] != word.charAt(k)){
            return false;
        } 
        char temp = board[r][c];
        board[r][c] = '#';

        boolean ans =  find(board, word, r-1, c, k+1) || find(board, word, r, c+1, k+1) ||
        find(board, word, r+1, c, k+1) || find(board, word, r, c-1, k+1);

        board[r][c] = temp;
        return ans;
    }
}