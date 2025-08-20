class Solution {
    public int minSteps(int n) {
        int  d = 2;
        int count = 0;
        while(n>1){
            while(n%d == 0){
                count += d;
                n /= d;
            }
            d++;
        }
        return count;
    }
}