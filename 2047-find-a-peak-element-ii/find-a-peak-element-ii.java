class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low=0;
        int n = mat.length;
        int m = mat[0].length;
        int high = m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int maxrow = maxRowInd(mat, n, m, mid);
            int left = mid-1>=0? mat[maxrow][mid-1]: -1;
            int right = mid+1<m? mat[maxrow][mid+1]: -1;
            if(mat[maxrow][mid]>left && mat[maxrow][mid]>right){
                return new int[]{maxrow, mid};
            } else if(mat[maxrow][mid]<left) high=mid-1;
            else low=mid+1;
        }
        return new int[]{-1,-1};
    }
    private int maxRowInd(int[][] mat, int n, int m, int col){
        int maxi = -1;
        int ind = -1;
        for(int i=0; i<n; i++){
            if(mat[i][col]>maxi){
                ind = i;
                maxi = mat[i][col];
            } 
        }
        return ind;
    }
}