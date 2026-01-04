class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]+1});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]+1});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0]=0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d=curr[0], node = curr[1];
            if(d>dist[node]) continue;
            for(int[] temp: graph.get(node)){
                int w=temp[1], next=temp[0];
                if(w+d<dist[next]){
                    dist[next]=w+d;
                    pq.offer(new int[]{w+d, next});
                }
            }
        }
        int result = 0;
        for(int[] edge: edges){
            int u=edge[0], v=edge[1], cnt=edge[2];
            int fromU= Math.max(0, maxMoves-dist[u]);
            int fromV = Math.max(0, maxMoves-dist[v]);
            result += Math.min(fromU+fromV, cnt);
        }
        for(int i=0; i<n; i++){
            if(dist[i]<=maxMoves) result++;
        }
        return result;
    }
}