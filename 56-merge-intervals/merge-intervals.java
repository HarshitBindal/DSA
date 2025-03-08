








class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
            while(i<n){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i+1;
            while(j<n && end >= intervals[j][0]){
                end = Math.max(end, intervals[j][1]);
                j++;
            }
            list.add(new int[]{start, end});
            i=j;
        }
        return list.toArray(new int[list.size()][]);
    }
}