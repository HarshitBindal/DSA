class Solution {
    public boolean checkDivisibility(int n) {
        int y = n;
        int sum = 0;
        int prod = 1;
        while(n>0){
            int x = n%10;
            n /= 10;
            sum += x;
            prod *= x;
        }
        return y%(sum+prod)==0;
    }
}