class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length(), m = t.length();
        if(n!=m) return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for(int i=0; i<n; i++){
            if(mapS[s.charAt(i)] != mapT[t.charAt(i)]){
                return false;
            }
            mapS[s.charAt(i)] = i+1;
            mapT[t.charAt(i)] = i+1;
        }
        return true;
    }
}