class Solution {
    public long lastInteger(long n) {
        long head = 1;
        long step = 1;
        int dir = 0;
        while(n>1){
            if(dir==0){
                dir = 1;
            }
            else {
                if(n%2 == 0){
                    head += step;
                }
                dir = 0;
            }
            n = (n+1)/2;
            step *= 2;
        }
        return head;
    }
}