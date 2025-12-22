class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int total = nums.length;
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        int j=0;
        int count = 0;
        while(j<nums.length && freq.size()<total){
            boolean del = false;
            for(int i=j; i<nums.length && i<j+3; i++){
                freq.put(nums[i], freq.get(nums[i])-1);
                if(freq.get(nums[i])==0) freq.remove(nums[i]);
                total--;
                del = true;
            }
            if(del) count++;
            j+=3;
        }
        return count;
    }
}