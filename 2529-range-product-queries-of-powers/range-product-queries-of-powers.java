class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Integer> powers = new ArrayList<>();
        for(int i=0; (1<<i)<=n; i++){
            if(((1<<i)&n) != 0) powers.add(1<<i);
        }
        int[] res = new int[queries.length];
        int j=0;
        for(int[] set: queries){
            int left = set[0];
            int right = set[1];
            long prod = 1;
            for(int i=left; i<=(Math.min(right, powers.size()-1)); i++){
                prod = (prod*powers.get(i))%mod;
            }
            res[j] = (int)prod;
            j++;
        }
        return res;
    }
}