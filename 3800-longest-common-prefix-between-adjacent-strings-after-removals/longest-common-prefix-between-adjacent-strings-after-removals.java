class Solution {
    public int[] longestCommonPrefix(String[] words) {
        int n = words.length;
        int[] ans = new int[words.length];
        int[] lcp = new int[n-1];
        for(int i=0; i<n-1; i++){
            lcp[i] = prefix(words[i], words[i+1]);
        }
        int[] pref = new int[n-1];
        int[] suff = new int[n-1];
        if(n >= 2){
            pref[0] = lcp[0];
            for(int i=1; i<n-1; i++){
                pref[i] = Math.max(pref[i-1], lcp[i]);
            }
        }
        if(n>=3){
            suff[n-2] = lcp[n-2];
            for(int i=n-3; i>=0; i--){
                suff[i] = Math.max(suff[i+1], lcp[i]);
            }
        } else if(n==2) {
            suff[0] = lcp[0];
        }
        for(int i=0; i<n; i++){
            if(i==0) ans[i] = (n>=3)? suff[1]: 0;
            else if(i==n-1) ans[i] = (n>=3) ? pref[n-3]: 0;
            else {
                int newlcp = prefix(words[i-1], words[i+1]);
                int left = (i>=2) ? pref[i-2]: 0;
                int right = (i+1 < n-1) ? suff[i+1] : 0;
                ans[i] = Math.max(newlcp, Math.max(left, right));
            }
        }
        return ans;
    }
    private int prefix(String a, String b){
        int i=0, j=0;
        int count = 0;
        while(i<a.length() && j<b.length() && a.charAt(i) == b.charAt(j)){
            count++;
            i++;
            j++;
        }
        return count;
    }
}