class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(list, graph, 0, curr);
        return list;
    }
    private void dfs(List<List<Integer>> list, int[][] graph, int node, List<Integer> curr){
        if(node==graph.length-1){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int neighbour: graph[node]){
            curr.add(neighbour);
            dfs(list, graph, neighbour, curr);
            curr.remove(curr.size()-1);
        }
    }
}