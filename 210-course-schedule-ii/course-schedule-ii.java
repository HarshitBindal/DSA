class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> s = new Stack<>();
        boolean[] rec = new boolean[numCourses];
        int[] ans = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(!dfs(i, s, visited, graph, rec)){
                    return new int[0];
                }
            }
        }
        int j = 0;
        while(!s.isEmpty()){
            ans[j] = s.pop();
            j++;
        }
        return ans;
    }
    private boolean dfs(int i, Stack<Integer> s, boolean[] visited, 
    List<List<Integer>> graph, boolean[] rec){
        visited[i] = true;
        rec[i] = true;
        for(int j: graph.get(i)){
            if(!visited[j]){
                if(!dfs(j, s, visited, graph, rec)){
                    return false;
                }
            } 
            else if(rec[j]) return false;
        }
        rec[i] = false;
        s.push(i);
        return true;
    }
}