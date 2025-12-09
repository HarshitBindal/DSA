class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] hash = new int[256];
        int l=0, r=0, startInd=-1, cnt=0;
        int minlen = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            hash[t.charAt(i)]++;
        }
        while(r<n){
            hash[s.charAt(r)]--;
            if(hash[s.charAt(r)]>=0){
                cnt++;
            }
            while(cnt==m){
                if(r-l+1 < minlen){
                    minlen = r-l+1;
                    startInd = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt--;
                l++;
            }
            r++;
        }
        return startInd==-1? "" : s.substring(startInd, startInd+minlen);
    }
}