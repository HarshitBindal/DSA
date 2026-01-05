class Solution {
    public int mod = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0, n});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dis=curr[0];
            int u=curr[1];
            for(int temp[]: graph.get(u)){
                int d=temp[1], v=temp[0];
                if(dis+d<dist[v]){
                    dist[v]=dis+d;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(dp,1,graph,dist);
    }
    private int dfs(int[] dp, int u, List<List<int[]>> graph, int[] dist){
        if(u==dist.length-1) return 1;
        if(dp[u]!=-1) return dp[u];
        long ways = 0;
        for(int[] curr: graph.get(u)){
            int v=curr[0];
            if(dist[u]>dist[v]){
                ways = (ways+dfs(dp,v,graph,dist))%mod;
            }
        }
        return dp[u]=(int)ways;
    }
}