class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int it: graph.get(curr)){
                indegree[it]--;
                if(indegree[it]==0) q.offer(it);
            }
        }
        for(int i=0; i<numCourses; i++){
            if(indegree[i]!=0) return false;
        }
        return true;
    }
}