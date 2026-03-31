class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        StringBuilder word = new StringBuilder("");
        for(int i=0; i<m+n-1; i++){
            word.append('$');
        }
        for(int i=0; i<n; i++){
            if(str1.charAt(i)=='T'){
                int i1=i;
                for(int j=0; j<m;j++){
                    if(word.charAt(i1)!='$' && word.charAt(i1)!=str2.charAt(j)){
                        return "";
                    }
                    word.setCharAt(i1, str2.charAt(j));
                    i1++;
                }
            }
        }
        boolean[] change = new boolean[n+m-1];
        for(int i=0; i<n+m-1; i++){
            if(word.charAt(i)=='$'){
                word.setCharAt(i, 'a');
                change[i]=true;
            }
        }
        for(int i=0; i<n; i++){
            if(str1.charAt(i)=='F'){
                if(isSame(word, str2, i, m)){
                    boolean changed = false;
                    for(int k=i+m-1; k>=i; k--){
                        if(change[k]){
                            word.setCharAt(k,'b');
                            changed = true;
                            break;
                        }
                    }
                    if(!changed) return "";
                }
            }
        }
        return word.toString();
    }
    private boolean isSame(StringBuilder sb, String str, int ind, int m){
        for(int i=0; i<m; i++){
            if(sb.charAt(ind+i)!=str.charAt(i)) return false;
        }
        return true;
    }
}