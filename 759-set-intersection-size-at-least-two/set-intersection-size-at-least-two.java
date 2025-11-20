class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (x,y) -> {
            if(x[1]==y[1]) return y[0]-x[0];
            return x[1]-y[1];
        });
        int p1=-1, p2=-1;
        int ans = 0;
        for(int[] it: intervals){
            int a = it[0], b = it[1];
            if(p2>=a && p2<=b && p1>=a && p1<=b){
                continue;
            }
            else if(p1>=a && p1<=b && p2<=a){
                ans++;
                p2 = p1;
                p1 = b;
            }
            else {
                ans+=2;
                p2 = b-1;
                p1 = b;
            }
        }
        return ans;
    }
}