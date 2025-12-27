class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[list.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==destination) return true;
            for(int neighbour: list.get(curr)){
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour]=true;
                } 
            }
        }
        return false;
    }
}