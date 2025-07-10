class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();
        for(int i=0; i<n; i++){
            revGraph.add(new ArrayList<>());
        }
        int[] outdegree = new int[n];
        for(int i=0; i<n; i++){
            for(int v: graph[i]){
                revGraph.get(v).add(i);
                outdegree[i]++;
            }
            // for(int j=0; j<graph[i].length; j++){
            //     revGraph.get(j).add(i);
            //     outdegree[revGraph.get(j).get(i)]++;
            // }
        }
        List<Integer> ans = new ArrayList<>();
        // for(int i=0; i<n; i++){
        //     for(int j=0; j<revGraph[i].size(); j++){
        //         outdegree[graph[i][j]]++;
        //     }
        // }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++){
            if(outdegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int front = q.poll();
            vis[front]  = true;
            for(int neighbour: revGraph.get(front)){
                outdegree[neighbour]--;
                if(outdegree[neighbour]==0) q.add(neighbour);
            }
        }
        for(int i=0; i<vis.length; i++){
            if(vis[i]==true) ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}