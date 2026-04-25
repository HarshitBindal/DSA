class Solution {
    public boolean validDigit(int n, int x) {
        boolean cond= false;
        while(n>0){
            int rem = n%10;
            if(rem==x){
                cond=true;
                if(x==0) return true;
            } 
            if(n==x) return false;
            n /= 10;
        }
        return cond;
    }
}