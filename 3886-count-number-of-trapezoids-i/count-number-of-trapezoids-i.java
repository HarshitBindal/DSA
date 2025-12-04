class Solution {
    public int countTrapezoids(int[][] points) {
        long mod = 1000000007L;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] p: points){
            map.put(p[1], map.getOrDefault(p[1],0)+1);
        }
        long[] arr = new long[map.size()];
        int ind = 0;
        for(int v: map.values()){
            long x = v;
            arr[ind++] = x*(x-1)/2;
        }
        int n = arr.length;
        long[] suffix = new long[n+1];
        for(int i=n-1; i>=0; i--){
            suffix[i] = (arr[i]+suffix[i+1])%mod;
        }
        long count = 0;
        for(int i=0; i<n; i++){
            count = (count + (arr[i]*suffix[i+1])%mod)%mod;
        }
        return (int)count;
    }
}