class Solution {
    public int binaryGap(int n) {
        int maxi = 0;
        int lastInd = -1, ind=0;
        while(n>0){
            if((n&1)==1){
                if(lastInd!=-1) maxi = Math.max(maxi, ind-lastInd);
                else maxi=0;
                lastInd=ind;
            }
            ind++;
            n=n>>1;
        }
        return maxi;
    }
}