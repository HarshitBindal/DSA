class Solution {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int[] distx = new int[n];
        int[] disty = new int[n];
        int[] distz = new int[n];
        Arrays.fill(distx, -1);
        Arrays.fill(disty, -1);
        Arrays.fill(distz, -1);
        bfs(graph, distx, x);
        bfs(graph, disty, y);
        bfs(graph, distz, z);
        int cnt = 0;
        for(int i=0; i<n; i++){
            int a = distx[i];
            int b = disty[i];
            int c = distz[i];
            int mini = Math.min(a, Math.min(b,c));
            int maxi = Math.max(a, Math.max(b,c));
            int mid = a+b+c-mini-maxi;
            if(maxi*maxi==mini*mini + mid*mid) cnt++;
        }
        return cnt;
    }
    private void bfs(List<List<Integer>> graph, int[] dist, int u){
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        Queue<Integer> q = new LinkedList<>();
        dist[u]=0;
        q.offer(u);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it: graph.get(node)){
                if(dist[it]==-1){
                    dist[it]=dist[node]+1;
                    q.offer(it);
                }
            }
        }
    }
}