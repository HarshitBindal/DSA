class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            pq.add(nums[i]);
        }
        for(int j=1; j<k; j++){
            pq.poll();
        }
        return pq.peek();
    }
}