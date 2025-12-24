class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int apples = 0;
        for(int x: apple){
            apples += x;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x: capacity){
            pq.offer(x);
        }
        int sum=0, count=0;
        while(apples>sum){
            sum += pq.poll();
            count++;
        }
        return count;
    }
}