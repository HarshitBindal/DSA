class Solution {
    public int absDifference(int[] nums, int k) {
        PriorityQueue<Integer> maxis = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minis = new PriorityQueue<>();
        for(int num: nums){
            maxis.offer(num);
            minis.offer(num);
        }
        int ans = 0;
        for(int i=0; i<k; i++){
            ans += maxis.poll();
            ans -= minis.poll();
        }
        return ans;
    }
}