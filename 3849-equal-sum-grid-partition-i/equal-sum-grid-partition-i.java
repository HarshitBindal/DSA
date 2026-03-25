class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        long[] rowsum = new long[n];
        long[] colsum = new long[m];
        for(int i=0; i<n; i++){
            long sum = 0;
            for(int j=0; j<m; j++){
                sum+=(long)grid[i][j];
                colsum[j]+=(long)(grid[i][j]);
            }
            rowsum[i]=sum;
        }
        long[] rprefix = new long[n];
        long[] rsuffix = new long[n];
        long[] cprefix = new long[m];
        long[] csuffix = new long[m];
        rprefix[0]=rowsum[0];
        cprefix[0]=colsum[0];
        for(int i=1; i<n; i++){
            rprefix[i]=rprefix[i-1]+rowsum[i];
        }
        for(int i=1; i<m; i++){
            cprefix[i]=cprefix[i-1]+colsum[i];
        }
        rsuffix[n-1]=rowsum[n-1];
        csuffix[m-1]=colsum[m-1];
        for(int i=n-2; i>=0; i--){
            rsuffix[i]=rsuffix[i+1]+rowsum[i];
        }
        for(int i=m-2; i>=0; i--){
            csuffix[i]=csuffix[i+1]+colsum[i];
        }
        for(int i=0; i<n-1; i++){
            if(rprefix[i]==rsuffix[i+1]) return true;
        }
        for(int i=0; i<m-1; i++){
            if(cprefix[i]==csuffix[i+1]) return true;
        }
        return false;
    }
}