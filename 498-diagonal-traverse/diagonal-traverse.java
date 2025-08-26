class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int i=0, j=0, d=1;
        int[] ans = new int[m*n];
        for(int k=0; k<m*n; k++){
            ans[k] = mat[i][j];
            i -= d;
            j += d;
            if(i>=n){
                i=n-1;
                j+=2;
                d = -d;
            }
            if(j>=m){
                j=m-1;
                i+=2;
                d = -d;
            }
            if(i<0){
                i=0;
                d = -d;
            }
            if(j<0){
                j=0;
                d = -d;
            }
        }
        return ans;
    }
}