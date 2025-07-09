class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        for(int i=0; i<n; i++){
            if(visited[i]==-1){
                if(dfs(i, 0, visited, graph)==false) return false;
            }
        }
        return true;
    }
    private boolean dfs(int i, int color, int[] visited, int[][] graph){
        visited[i] = color;
        for(int neighbour: graph[i]){
            if(visited[neighbour]==-1){
                if(dfs(neighbour, 1-color, visited, graph)==false){
                    return false;
                }
            }
                else if(visited[neighbour]==color){
                    return false;
                }
        }
        return true;
    }
}