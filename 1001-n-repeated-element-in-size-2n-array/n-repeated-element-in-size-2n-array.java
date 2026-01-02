class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        int maxi = -1;
        int ele = -1;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue()>maxi){
                maxi = entry.getValue();
                ele = entry.getKey();
            }
        }
        return ele;
    }
}