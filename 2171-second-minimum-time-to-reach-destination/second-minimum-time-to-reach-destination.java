class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,1});
        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[1]=0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int tm = curr[0];
            int node = curr[1];
            if(tm>dist2[node]) continue;
            if((tm/change)%2==1) tm=(tm/change+1)*change;
            for(int it: graph.get(node)){
                int newtime = tm+time;
                if(newtime<dist1[it]){
                    dist2[it]=dist1[it];
                    dist1[it]=newtime;
                    pq.offer(new int[]{newtime, it});
                }
                else if(dist1[it]<newtime && newtime<dist2[it]){
                    dist2[it]=newtime;
                    pq.offer(new int[]{newtime, it});
                }
            }
        }
        return dist2[n];
    }
}