class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append('.');
        }
        for(int i=0; i<n; i++){
            board.add(sb.toString());
        }
        solve(0, board, ans, n);
        return ans;
    }
    private void solve(int col, List<String> board, List<List<String>> ans, int n){
        if(col==n){
            ans.add(new ArrayList<>(board));
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(row, col, board, n)){
                char[] rowArr = board.get(row).toCharArray();
                rowArr[col] = 'Q';
                board.set(row, new String(rowArr));
                
                solve(col+1, board, ans, n);
                rowArr[col] = '.';
                board.set(row, new String(rowArr));
            }
        }
    }
    private boolean isSafe(int row, int col, List<String> board, int n){
        int duprow = row;
        int dupcol = col;
        while(row>=0 && col>=0){
            if(board.get(row).charAt(col)=='Q') return false;
            row--;
            col--;
        }
        row = duprow;
        col = dupcol;
        while(col>=0){
            if(board.get(row).charAt(col)=='Q') return false;
            col--;
        }
        row = duprow;
        col = dupcol;
        while(col>=0 && row<n){
            if(board.get(row).charAt(col)=='Q') return false;
            row++;
            col--;
        }
        return true;
    }
}