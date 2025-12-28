class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
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