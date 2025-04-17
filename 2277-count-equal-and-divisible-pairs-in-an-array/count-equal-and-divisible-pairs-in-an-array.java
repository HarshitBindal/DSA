class Solution {
    public int countPairs(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        for(List<Integer> indices : map.values()){
            for(int j=0; j<indices.size(); j++){
                for(int i=j+1; i<indices.size(); i++){
                    int idx1 = indices.get(j);
                    int idx2 = indices.get(i);
                    if((idx1 * idx2)%k == 0){
                        ans ++ ;
                    }
                }
            }
        }
        return ans;
    }
}