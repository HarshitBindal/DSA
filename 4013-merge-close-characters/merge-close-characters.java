class Solution {
    public String mergeCharacters(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int i=0;
        while(i<n){
            int j=i+1;
            while(j<n && j<=i+k){
                if(sb.charAt(i)==sb.charAt(j)){
                    sb.deleteCharAt(j);
                    n=sb.length();
                    i=-1;
                    break;
                }
                j++;
            }
            i++;
        }
        return sb.toString();
    }
}