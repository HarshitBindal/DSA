class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];
        for(int i=0; i<m; i++){
            dfs(0, i, pacific, heights);
        }
        for(int i=0; i<n; i++){
            dfs(i, m-1, atlantic, heights);
        }
        for(int i=0; i<m; i++){
            dfs(n-1, i, atlantic, heights);
        }
        for(int i=0; i<n; i++){
            dfs(i, 0, pacific, heights);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    private void dfs(int row, int col, boolean[][] ocean, int[][] heights){
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int n = ocean.length;
        int m = ocean[0].length;
        ocean[row][col] = true;
        for(int[] d: directions){
            int nrow = d[0]+row;
            int ncol = d[1]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
            !ocean[nrow][ncol] && heights[nrow][ncol]>=heights[row][col]){
                dfs(nrow, ncol, ocean, heights);
            }
        }
    }
}