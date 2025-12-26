class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        boolean[][] visit = new boolean[n][m];
        visit[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                if((r==0 || r==n-1 || c==0 || c==m-1) &&
                !(r==entrance[0] && c==entrance[1])) return steps;
                int[] drow = {-1,0,1,0};
                int[] dcol = {0,1,0,-1};
                for(int i=0; i<4; i++){
                    int nrow = drow[i]+r;
                    int ncol = dcol[i]+c;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m &&
                    !visit[nrow][ncol] && maze[nrow][ncol]=='.'){
                        visit[nrow][ncol]=true;
                        q.offer(new int[]{nrow, ncol});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}