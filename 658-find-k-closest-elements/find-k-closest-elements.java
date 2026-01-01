class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int diffA = Math.abs(a-x);
            int diffB = Math.abs(b-x);
            if(diffA!=diffB) return diffA-diffB;
            return a-b;
        });
        for(int num: arr) pq.offer(num);
        List<Integer> res = new ArrayList<>();
        while(k-->0){
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}