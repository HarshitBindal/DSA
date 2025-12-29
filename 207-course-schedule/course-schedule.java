class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int courses = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] course: prerequisites){
            list.get(course[0]).add(course[1]);
            indegree[course[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.offer(i);
                courses++;
            } 
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int neighbour: list.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    courses++;
                    q.offer(neighbour);
                }
            }
        }
        return courses == numCourses;
    }
}