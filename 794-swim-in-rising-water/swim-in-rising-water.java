class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        heap.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[n][n];
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int wt = curr[0];
            int r = curr[1], c = curr[2];

            if(visited[r][c]) continue;
            visited[r][c] = true;
            if(r==n-1 && c==n-1){
                return wt;
            }
            for(int i=0; i<4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow>=0 && ncol>=0 && ncol<n && nrow<n && !visited[nrow][ncol]){
                    int path = Math.max(wt, grid[nrow][ncol]);
                    heap.offer(new int[]{path, nrow, ncol});
                }
            }
        }
        return -1;
    }
}