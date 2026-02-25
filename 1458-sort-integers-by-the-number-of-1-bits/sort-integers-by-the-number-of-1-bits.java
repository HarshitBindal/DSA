class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int x: arr){
            int bits = Integer.bitCount(x);
            pq.offer(new int[]{x,bits});
        }
        for(int i=0; i<arr.length; i++){
            arr[i]=pq.poll()[0];
        }
        return arr;
    }
}