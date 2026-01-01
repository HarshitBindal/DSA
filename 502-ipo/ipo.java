class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> capPQ = new PriorityQueue<>((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> profit = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            capPQ.offer(new int[]{capital[i], profits[i]});
        }
        while(k-->0){
            while(!capPQ.isEmpty() && capPQ.peek()[0]<=w){
                profit.offer(capPQ.poll()[1]);
            }
            if(profit.isEmpty()) break;
            w += profit.poll();
        }
        return w;
    }
}