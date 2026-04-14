class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->a[0]-b[0]);
        List<Integer> factories = new ArrayList<>();
        for(int[] it: factory){
            for(int i=0; i<it[1]; i++){
                factories.add(it[0]);
            }
        }
        long[][] dp = new long[robot.size()][factories.size()];
        for(long[] curr: dp){
            Arrays.fill(curr, -1);
        }
        return solve(0,0,robot,factories,dp);
    }
    private long solve(int i, int j, List<Integer> robot, List<Integer> factories, long[][] dp){
        if(i>=robot.size()){
            return 0;
        }
        if(j>=factories.size()){
            return (long)1e13;
        }
        if(dp[i][j]!=-1L) return dp[i][j];
        long take = Math.abs(robot.get(i)-factories.get(j))+solve(i+1,j+1,robot,factories,dp);
        long skip = solve(i,j+1,robot,factories,dp);
        return dp[i][j] = Math.min(take,skip);
    }
}