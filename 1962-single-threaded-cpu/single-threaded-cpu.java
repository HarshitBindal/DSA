class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] arr = new Task[n];
        for(int i=0; i<n; i++){
            arr[i]=new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(arr, (a,b)->{
            return Integer.compare(a.enqueueTime, b.enqueueTime);
        });
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)->{
            if(a.processingTime==b.processingTime) return Integer.compare(a.ind,b.ind);
            return Integer.compare(a.processingTime, b.processingTime);
        });
        int[] ans = new int[n];
        int ansidx = 0;
        int taskidx = 0;
        int time = 0;
        while(ansidx<n){
            while(taskidx<n && arr[taskidx].enqueueTime<=time){
                pq.offer(arr[taskidx]);
                taskidx++;
            }
            if(pq.isEmpty()) time=arr[taskidx].enqueueTime;
            else {
                time += pq.peek().processingTime;
                ans[ansidx]=pq.poll().ind;
                ansidx++;
            }
        }
        return ans;
    }
}
class Task{
    int ind;
    int enqueueTime;
    int processingTime;
    Task(int ind, int en, int pro){
        this.ind=ind;
        this.enqueueTime=en;
        this.processingTime=pro;
    }
}