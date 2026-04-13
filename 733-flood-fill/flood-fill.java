class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc, image[sr][sc]});
        boolean[][] visited = new boolean[n][m];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        image[sr][sc]=color;
        visited[sr][sc]=true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int prevCol = curr[2];
            for(int i=0; i<4; i++){
                int nrow = drow[i]+curr[0];
                int ncol = dcol[i]+curr[1];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                image[nrow][ncol]==prevCol && !visited[nrow][ncol]){
                    q.offer(new int[]{nrow, ncol, image[nrow][ncol]});
                    image[nrow][ncol] = color;
                    visited[nrow][ncol]=true;
                }
            }
        }
        return image;
    }
}