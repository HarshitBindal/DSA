class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0; i<points.length; i++){
            int[] arr = points[i];
            int x = arr[0];
            int y = arr[1];
            int dist = (int)(Math.pow(x,2)+Math.pow(y,2));
            pq.offer(new int[]{dist, i});
        }
        int[][] res = new int[k][2];
        int j=0;
        while(k-->0){
            int[] temp = pq.poll();
            int ind = temp[1];
            res[j] = points[ind];
            j++;
        }
        return res;
    }
}