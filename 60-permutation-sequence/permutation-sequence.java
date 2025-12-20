class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i=1; i<n; i++){
            fact[i] = fact[i-1]*i;
            nums.add(i);
        }
        nums.add(n);
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>=1; i--){
            int ind = k/fact[i-1];
            sb.append(nums.get(ind));
            nums.remove(ind);
            k = k%fact[i-1];
        }
        return sb.toString();
    }
}