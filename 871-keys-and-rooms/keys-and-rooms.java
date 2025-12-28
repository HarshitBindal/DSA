class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = rooms.size();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int it: rooms.get(i)){
                graph.get(i).add(it);
            }
        }
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited);
        for(boolean it: visited){
            if(it==false) return false;
        }
        return true;
    }
    private void dfs(List<List<Integer>> graph, int room, boolean[] visited){
        visited[room] = true;
        for(int neighbour: graph.get(room)){
            if(!visited[neighbour]){
                dfs(graph, neighbour, visited);
            }
        }
    }
}