class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[] { i, j };
        //         }
        //     }
        // }
        // return new int[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(map.containsKey(target-x)){
                return new int[] {map.get(target-x), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}