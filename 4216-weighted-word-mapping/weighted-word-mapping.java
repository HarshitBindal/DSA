class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        int[] arr = new int[n];
        int ind=0;
        for(String word: words){
            int sum=0;
            for(int i=0; i<word.length(); i++){
                sum += weights[(word.charAt(i)-'a')];
            }
            arr[ind++]=sum%26;
        }
        StringBuilder sb = new StringBuilder("");
        for(int it: arr){
            sb.append((char)(25-it+'a'));
        }
        return sb.toString();
    }
}