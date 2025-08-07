class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int maxele = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            maxele = Math.max(maxele, num);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] dp = new int[maxele+1];
        dp[0] = 0;
        dp[1] = map.getOrDefault(1, 0);
        for(int i=2; i<=maxele; i++){
            int isum = i*map.getOrDefault(i, 0);
            int pick = isum + dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[maxele];
    }
}