class Solution {
    public String reverseByType(String s) {
        int n = s.length();
        boolean[] flag = new boolean[n];
        StringBuilder special = new StringBuilder("");
        StringBuilder letters = new StringBuilder("");
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                flag[i]=true;
                letters.append(ch);
            }
            else special.append(ch);
        }
        special.reverse();
        letters.reverse();
        StringBuilder sb = new StringBuilder("");
        int i=0, j=0;
        for(boolean it: flag){
            if(it){
                sb.append(letters.charAt(i));
                i++;
            }
            else {
                sb.append(special.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}