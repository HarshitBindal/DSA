class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum  = 0;
        int count = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            sum += num;
            if(sum == goal) count++;
            if(freq.containsKey(sum-goal)){
                count += freq.get(sum-goal);
            }
            freq.put(sum, freq.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}