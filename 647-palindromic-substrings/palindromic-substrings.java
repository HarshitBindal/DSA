class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(palindrome(s.substring(i,j+1))) count++;
            }
        }
        return count;
    }
    private boolean palindrome(String str){
        int s=0, e=str.length()-1;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}