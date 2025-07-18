class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road: roads){
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});

        long[] visited = new long[n];
        Arrays.fill(visited, Long.MAX_VALUE);
        visited[0] = 0;
        int mini = Integer.MAX_VALUE;
        int count = 0;

        int[] ways = new int[n];
        ways[0] = 1;
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int u = (int)curr[1];
            long dist = curr[0];
            if(dist > visited[u]) continue;

            for(int[] tmp: graph.get(u)){
                int v = tmp[0];
                int w = tmp[1];
                if(dist + w < visited[v]){
                    visited[v] = dist + w;
                    ways[v] = ways[u];
                    pq.offer(new long[]{dist+w, v});
                } else if(dist + w == visited[v]){
                    ways[v] = (ways[v]+ways[u])%mod;
                }
            }
        }
        return ways[n-1];
    }
}