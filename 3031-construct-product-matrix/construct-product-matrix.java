class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        final int mod = 12345;
        int[] arr = new int[n*m];
        int ind = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[ind++] = grid[i][j];
            }
        }
        int len = m*n;
        long[] prefix = new long[len];
        long[] suffix = new long[len];
        prefix[0]=1;
        suffix[len-1]=1;
        for(int i=1; i<len; i++){
            prefix[i] = (prefix[i-1]*arr[i-1])%mod;
        }
        for(int i=len-2; i>=0; i--){
            suffix[i] = (suffix[i+1]*arr[i+1])%mod;
        }
        ind=0;
        int[][] res = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[i][j]=(int)((prefix[ind]*suffix[ind])%mod);
                ind++;
            }
        }
        return res;
    }
}