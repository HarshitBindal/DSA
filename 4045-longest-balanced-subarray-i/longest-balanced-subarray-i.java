class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxlen=0;
        for(int i=0; i<n; i++){
            HashMap<Integer, Integer> odd = new HashMap<>();
            HashMap<Integer, Integer> even = new HashMap<>();
            for(int j=i; j<n; j++){
                if(nums[j]%2==0) even.put(nums[j], even.getOrDefault(nums[j],0)+1);
                else odd.put(nums[j], odd.getOrDefault(nums[j],0)+1);
                if(odd.size()==even.size()) maxlen = Math.max(maxlen,j-i+1);
            }
        }
        return maxlen;
    }
}