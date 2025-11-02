class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int col=matrix[0].length-1;
        while(col>=0 && row<matrix.length){
            if(target == matrix[row][col]) return true;
            else if(matrix[row][col]>target) col--;
            else row++;
        }
        return false;
    }
}