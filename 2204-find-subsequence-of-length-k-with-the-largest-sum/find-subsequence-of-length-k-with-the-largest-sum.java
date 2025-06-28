class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] ans = new int[k];
        for(int i=0; i<nums.length; i++){
            pq.offer(new int[]{nums[i], i});
            if(pq.size()>k) pq.poll();
        }
        List<int[]> list = new ArrayList<>(pq);
        list.sort((a,b) -> a[1]-b[1]);

        for(int i=0; i<list.size(); i++){
            int[] top = list.get(i);
            ans[i] = top[0];
        }
        return ans;
    }
}