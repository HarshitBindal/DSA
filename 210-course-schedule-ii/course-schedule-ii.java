class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        List<Integer> list = new ArrayList<>();
        int pos = 0;
        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        int courses=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            list.add(curr);
            courses++;
            for(int it: graph.get(curr)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                } 
            }
        }
        if(courses!=numCourses) return new int[0];
        int[] res = new int[list.size()];
        for(int i=0; i<res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}