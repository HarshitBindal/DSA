class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int minval = Integer.MAX_VALUE;
        long sum = 0;
        int neg=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]<0){
                    neg++;
                }
                minval = Math.min(minval, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if(neg%2==0) return sum;
        return sum-(2L*minval);
    }
}