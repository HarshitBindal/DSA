class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i<4; i++){
            if(isEqual(mat, target)) return true;
            rotate(mat);
        }
        return false;
    }
    private void rotate(int[][] mat){
        int n = mat.length;
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
    }
    private boolean isEqual(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
}