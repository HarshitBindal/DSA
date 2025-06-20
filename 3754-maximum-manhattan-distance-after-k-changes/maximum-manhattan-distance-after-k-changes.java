class Solution {
    public int maxDistance(String s, int k) {
        if(k == s.length()) return k;
        int nw = solve('N', 'W', s, k);
        int ne = solve('N', 'E', s, k);
        int sw = solve('S', 'W', s, k);
        int se = solve('S', 'E', s, k);
        return Math.max(Math.max(nw, ne), Math.max(sw, se));
    }
    private int solve(char a, char b, String s, int k){
        int dist = 0, ans = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==a || s.charAt(i)==b){
                dist++;
            } else {
                if(k>0) {
                    k--;
                    dist++;
                } else {
                    ans = Math.max(ans, dist);
                    dist--;
                }
            }
        }
        ans = Math.max(ans, dist);
        return ans;
    }
}