class Solution {
    public int countOdds(int low, int high) {
        int x = (high-low)/2;
        if((low & 1)==0 && (high & 1)==0) return x;
        return x+1;
    }
}