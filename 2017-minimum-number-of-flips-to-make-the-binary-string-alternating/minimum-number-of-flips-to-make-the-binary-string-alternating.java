class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s+s;
        int cnt=Integer.MAX_VALUE;
        int diff1=0, diff2=0;
        for(int i=0; i<2*n; i++){
            char ch = str.charAt(i);
            if((i%2==0 && ch=='0')||(i%2!=0 && ch=='1')) diff1++;
            if((i%2==0 && ch=='1')||(i%2!=0 && ch=='0')) diff2++;
            if(i>=n){
                char prev = str.charAt(i-n);
                if(((i-n)%2==0 && prev=='0')||((i-n)%2!=0 && prev=='1')) diff1--;
                if(((i-n)%2==0 && prev=='1')||((i-n)%2!=0 && prev=='0')) diff2--;
            }
            if(i>=n-1){
                cnt = Math.min(cnt, Math.min(diff1, diff2));
            }
        }
        return cnt;
    }
}