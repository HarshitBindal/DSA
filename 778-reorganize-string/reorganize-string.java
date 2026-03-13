class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int maxi = -1;
        int ind = -1;
        for(int i=0; i<n; i++){
            freq[s.charAt(i)-'a']++;
            if(freq[s.charAt(i)-'a']>maxi){
                maxi = freq[s.charAt(i)-'a'];
                ind = s.charAt(i)-'a';
            }
        }
        if(maxi > (n+1)/2) return "";
        char[] arr = new char[n];
        int i=0;
        while(freq[ind]>0){
            arr[i]=(char)(ind+'a');
            freq[ind]--;
            i+=2;
        }
        for(int j=0; j<26; j++){
            while(freq[j]>0){
                if(i>=n) i=1;
                arr[i]=(char)(j+'a');
                i+=2;
                freq[j]--;
            }
        }
        return new String(arr);
    }
}