class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        int[] h = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                h[j] = mat[i][j]==1? h[j]+1:0;
            }
            for(int j=0; j<m; j++){
                int mn = h[j];
                for(int k=j; k>=0 && mn>0; k--){
                    mn = Math.min(mn, h[k]);
                    count += mn;
                }
            }
        }
        return count;
    }
}