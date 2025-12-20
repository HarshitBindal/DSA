class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        char[][] chars = new char[n][m];
        for(int i=0; i<n; i++){
            chars[i] = strs[i].toCharArray();
        }
        int ans = 0;
        for(int i=0; i<m; i++){
            int j = 0;
            while(j<n-1){
                if(chars[j+1][i]-chars[j][i] < 0){
                    ans++;
                    break;
                }
                j++;
            }
        }
        return ans;
    }
}