class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, k});
        int[] visited = new int[n+1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[k] = 0;
        
        int dist = -1;
        int nodes = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int u = curr[1];
            if(d>visited[u]) continue;

            dist = Math.max(dist, d);
            nodes++;
            for(int[] temp: graph.get(u)){
                int v = temp[0];
                int w = temp[1];
                if(w + d < visited[v]){
                    visited[v] = w+d;
                    pq.offer(new int[]{w+d, v});
                }
            }
        }
        return nodes==n? dist: -1;
    }
}