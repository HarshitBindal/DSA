class Solution {
    public int largestPrime(int n) {
        if(n==1) return 0;
        int ans = 2;
        int i=3, sum=2;
        while(sum+i<=n){
            if(isPrime(i)){
                sum += i;
                if(isPrime(sum)) ans = sum;
            }
            i+= 2;
        }
        return ans;
    }
    private boolean isPrime(int n){
        if(n%2==0) return false;
        for(int i=3; i*i<=n; i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}