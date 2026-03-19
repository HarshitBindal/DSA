class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] sumx = new int[m];
        int[] sumy = new int[m];
        int total=0;
        for(int i=0; i<n; i++){
            int rx=0, ry=0;
            for(int j=0; j<m; j++){
                if(grid[i][j]=='X') rx++;
                else if(grid[i][j]=='Y') ry++;
                sumx[j]+=rx;
                sumy[j]+=ry;
                if(sumx[j]>0 && sumx[j]==sumy[j]) total++;
            }
        }
        return total;
    }
}