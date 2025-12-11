class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int len = buildings.length;
        if(len<=4) return 0;
        int[] rmin = new int[n+1];
        int[] rmax = new int[n+1];
        int[] cmin = new int[n+1];
        int[] cmax = new int[n+1];
        Arrays.fill(rmin, n+1);
        Arrays.fill(cmin, n+1);
        for(int[] p:buildings){
            int x = p[0], y = p[1];
            rmin[y] = Math.min(rmin[y], x);
            rmax[y] = Math.max(rmax[y], x);
            cmin[x] = Math.min(cmin[x], y);
            cmax[x] = Math.max (cmax[x], y);
        }
        int count = 0;
        for(int[] p: buildings){
            int x = p[0], y = p[1];
            if(x>rmin[y] && x<rmax[y] && y>cmin[x] && y<cmax[x]){
                count++;
            }
        }
        return count;
    }
}