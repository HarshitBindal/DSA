class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                res = Math.min(res, i-map.get(nums[i]));
            }
            map.put(reverse(nums[i]), i);
        }
        return res==Integer.MAX_VALUE? -1: res;
    }
    private int reverse(int x){
        int num = 0;
        while(x>0){
            int rem = x%10;
            x /= 10;
            num = num*10 + rem;
        }
        return num;
    }
}