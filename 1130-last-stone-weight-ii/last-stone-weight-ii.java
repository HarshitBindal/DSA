class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int stone: stones) sum+= stone;
        int half = (sum+1)/2;
        int[][] dp = new int[n][half+1];
        for(int[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return helper(0,0,stones,dp,sum,half);
    }
    private int helper(int ind, int total, int[] stones, int[][] dp, int sum, int target){
        if(total>=target || ind==stones.length){
            return Math.abs(total-(sum-total));
        }
        if(dp[ind][total]!=-1) return dp[ind][total];
        return dp[ind][total]=Math.min(helper(ind+1,total+stones[ind],stones,dp,sum,target),
        helper(ind+1,total,stones,dp,sum,target));
    }
}