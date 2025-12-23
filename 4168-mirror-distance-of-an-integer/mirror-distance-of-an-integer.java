class Solution {
    public int mirrorDistance(int n) {
        String str = String.valueOf(n);
        String reversed = new StringBuilder(str).reverse().toString();
        int x = Integer.valueOf(reversed);
        return Math.abs(n-x);
    }
}