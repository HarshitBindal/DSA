class Solution {
    public int nthUglyNumber(int n) {
        int[] primes = {2,3,5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        long curr = 1L;
        for(int i=0; i<n; i++){
            curr = pq.poll();
            for(int num: primes){
                if(!set.contains(num*curr)){
                    pq.add(num*curr);
                    set.add(num*curr);
                }
            }
        }
        return (int)curr;
    }
}