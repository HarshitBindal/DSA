class Solution {
    public boolean completePrime(int num) {
        int x = num;
        while(x != 0){
            if(!isPrime(x)) return false;
            x = x/10;
        }
        int p = 1;
        while(p<=num) p *= 10;
        p /= 10;
        while(p>0){
            int y = num%p;
            if(y != 0 && !isPrime(y)) return false;
            p /= 10;
        }
        return true;
    }
    private boolean isPrime(int x){
        if(x == 1) return false;
        if(x==2) return true;
        for(int i=2; i<=Math.sqrt(x); i++){
            if(x%i == 0) return false;
        }
        return true;
    }
}