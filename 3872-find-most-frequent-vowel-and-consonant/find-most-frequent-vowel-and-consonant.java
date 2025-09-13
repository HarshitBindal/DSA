class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        int vowel = 0;
        int conso = 0;
        for(int i=0; i<s.length(); i++){
            int ind = s.charAt(i)-'a';
            freq[ind]++;
            if(ind == 0 || ind==4 || ind==8 || ind==14 || ind==20){
                vowel = Math.max(vowel, freq[ind]);
            }
            else {
                conso = Math.max(conso, freq[ind]);
            }
        }
        return vowel + conso;
    }
}