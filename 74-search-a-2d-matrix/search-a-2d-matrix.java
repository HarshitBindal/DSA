class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int rowS=0, rowE=n-1;
        while(rowS<=rowE){
            int midR = (rowS+rowE)/2;
            int colS=0, colE=m-1;
            while(colS<=colE){
                int midC = (colS+colE)/2;
                if(matrix[midR][midC]==target) return true;
                else if(matrix[midR][midC]<target){
                    colS=midC+1;
                } else colE=midC-1;
            }
            if(colS<m && matrix[midR][colS]>target) rowE=midR-1;
            else rowS=midR+1;
        }
        return false;
    }
}