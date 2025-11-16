class Solution {
    public int numSub(String s) {
        int mod = 1000000007;
        int n = s.length();
        int i=0;
        int total = 0;
        while(i<n){
            int consec = 1, prev = 0;
            while(i<n && s.charAt(i)=='1'){
                prev = (prev + consec)%mod;
                consec++;
                i++;
            }
            i++;
            total = (total + prev)%mod;
        }
        return total;
    }
}