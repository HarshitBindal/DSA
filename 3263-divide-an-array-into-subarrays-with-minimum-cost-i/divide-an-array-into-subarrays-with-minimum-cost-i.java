class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<n; i++){
            pq.offer(nums[i]);
        }
        return nums[0]+pq.poll()+pq.poll();
    }
}