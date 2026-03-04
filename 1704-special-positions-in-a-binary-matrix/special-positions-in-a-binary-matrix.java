class Solution {
    public int numSpecial(int[][] mat) {
        int cnt=0;
        int n = mat.length;
        int m = mat[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==1){
                    boolean poss = true;
                    for(int col=0; col<j; col++){
                        if(mat[i][col]==1){
                            poss = false;
                            break;
                        } 
                    }
                    for(int col=j+1; col<m; col++){
                        if(mat[i][col]==1){
                            poss = false;
                            break;
                        }
                    }
                    for(int row=0; row<i; row++){
                        if(mat[row][j]==1){
                            poss = false;
                            break;
                        }
                    }
                    for(int row=i+1; row<n; row++){
                        if(mat[row][j]==1){
                            poss = false;
                            break;
                        }
                    }
                    if(poss) cnt++;
                }
            }
        }
        return cnt;
    }
}