class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count=0;
        for(int i=left; i<=right; i++){
            int curr_cnt=0;
            int x = i;
            while(x>0){
                if((x&1)==1) curr_cnt++;
                x = x>>1;
            }
            if(isPrime(curr_cnt)){
                System.out.println(curr_cnt);
                count++;
            } 
        }
        return count;
    }
    private boolean isPrime(int x){
        if(x<=1) return false;
        if(x==2) return true;
        if(x%2==0) return false;
        for(int i=3; i*i<=x; i++){
            if(x%i==0) return false;
        }
        return true;
    }
}