class Solution {
    public int mirrorDistance(int n) {
        int x = 0;
        int y = n;
        while(y>0){
            int rem = y%10;
            x = x*10 + rem;
            y /= 10;
        }
        return Math.abs(n-x);
    }
}