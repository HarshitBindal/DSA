class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new double[]{v,prob});
            graph.get(v).add(new double[]{u,prob});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));
        pq.offer(new double[]{1.0, start_node});
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            double prob = curr[0];
            int node = (int)curr[1];
            if(node == end_node) return prob;
            if(visited[node]) continue;
            visited[node]=true;
            for(double[] temp: graph.get(node)){
                double currprob = temp[1];
                int v = (int)temp[0];
                if(!visited[v]){
                    pq.offer(new double[]{currprob*prob, v});
                }
            }
        }
        return 0.0;
    }
}