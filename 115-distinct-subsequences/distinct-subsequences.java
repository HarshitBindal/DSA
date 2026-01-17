class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] curr = new int[m+1];
        int[] prev = new int[m+1];
        prev[0]=1;
        curr[0]=1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int pick = 0;
                if(s.charAt(i-1)==t.charAt(j-1)) pick = prev[j-1];
                int notpick = prev[j];
                curr[j]=pick+notpick;
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}