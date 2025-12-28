class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int[] ans = new int[2];
        int i = 0;
        for(int it: set){
            ans[i++] = it;
        }
        return ans;
    }
}