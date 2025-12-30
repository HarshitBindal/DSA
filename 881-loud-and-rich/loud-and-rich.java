class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] ans = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
            ans[i]=i;
        }
        for(int[] curr: richer){
            graph.get(curr[0]).add(curr[1]);
            indegree[curr[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< indegree.length; i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v: graph.get(u)){
                if(quiet[ans[u]]<quiet[ans[v]]) ans[v]=ans[u];
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }
        return ans;
    }
}