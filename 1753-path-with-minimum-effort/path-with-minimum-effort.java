class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[n][m];

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[1], c = curr[2];
            int dist = curr[0];
            
            if(visited[r][c]) continue;
            visited[r][c] = true;
            if(r==n-1 && c==m-1){
                return dist;
            }
            for(int i=0; i<4; i++){
                int nrow = drow[i] + r;
                int ncol = dcol[i] + c;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                visited[nrow][ncol]==false){
                    int path = Math.max(dist, Math.abs(heights[r][c]-heights[nrow][ncol]));
                    pq.add(new int[]{path, nrow, ncol});
                }
            }
        }
        return -1;
    }
}