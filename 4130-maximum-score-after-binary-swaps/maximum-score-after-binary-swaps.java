class Solution {
    public long maximumScore(int[] nums, String s) {
        int n = nums.length;
        List<Integer> ones = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1') ones.add(i);
        }
        if(ones.size()==0) return 0;
        int ind = 0;
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            pq.offer(nums[i]);
            if(i==ones.get(ind)){
                ind++;
                ans += pq.poll();
            }
            if(ind == ones.size()) return ans; 
        }
        return ans;
    }
}