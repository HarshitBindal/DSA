class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();
        int MOD = 1000000007;
        long count = 0;
        for(long num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        HashMap<Long, Integer> leftmap = new HashMap<>();
        for(int j=0; j<nums.length; j++){
            long target = nums[j];
            if(map.get(target) == 1) map.remove(target);
            else map.put(target, map.get(target)-1);
            if(j>0 && j<nums.length-1){
                if(map.containsKey(target*2) && leftmap.containsKey(target*2)){
                    long a = leftmap.get(target*2);
                    long b = map.get(target*2);
                    count = (count + (a*b)%MOD)%MOD;
                }
            }
            leftmap.put(target, leftmap.getOrDefault(target, 0)+1);
        }
        return (int)count;
    }
}