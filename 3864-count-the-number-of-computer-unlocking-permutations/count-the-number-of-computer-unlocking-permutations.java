class Solution {
    static final long mod = 1000000007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int first = complexity[0];
        for(int i=1; i<n; i++){
            if(complexity[i]<=first) return 0;
        }
        long prod = 1;
        for(long i=2; i<n; i++){
            prod = (prod*i)%mod;
        }
        return (int)prod;
    }
}