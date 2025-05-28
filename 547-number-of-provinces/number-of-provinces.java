class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean visited[] = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        int num = 0;
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                num++;
                dfs(i, isConnected, visited);
            }
        }
        return num;
    }
    private void dfs(int node, int[][] adj, boolean[] visited){
        visited[node] = true;
        for(int i=0; i<adj.length; i++){
            if(adj[node][i]==1 && !visited[i]){
                dfs(i, adj, visited);
            }
        }
    }
}