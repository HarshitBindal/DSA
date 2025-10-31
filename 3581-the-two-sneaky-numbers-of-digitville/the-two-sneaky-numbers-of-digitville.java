class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        for(int num: nums){
            if(set.contains(num)) ans[i++]=num;
            else set.add(num);
        }
        return ans;
    }
}