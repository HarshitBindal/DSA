class Solution {
    public int findMaxVal(int n, int[][] restrictions, int[] diff) {
        long[] limit = new long[n];
        Arrays.fill(limit, (long)1e15);
        limit[0]=0;
        for(int[] r: restrictions){
            limit[r[0]]=r[1];
        }
        for(int i=1; i<n; i++){
            limit[i]=Math.min(limit[i], limit[i-1]+diff[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            limit[i]=Math.min(limit[i], limit[i+1]+diff[i]);
        }
        long res = 0;
        for(long it: limit){
            res = Math.max(res, it);
        }
        return (int)res;
    }
}