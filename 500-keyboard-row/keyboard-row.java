class Solution {
    public String[] findWords(String[] words) {
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        char[] arr3 = str3.toCharArray();
        HashSet<Character>[] map = new HashSet[3];
        for(int i=0; i<3; i++){
            map[i] = new HashSet<>();
        }
        for(char ch: arr1){
            map[0].add(ch);
        }
        for(char ch: arr2){
            map[1].add(ch);
        }
        for(char ch: arr3){
            map[2].add(ch);
        }
        List<String> list = new ArrayList<>();
        for(String w: words){
            String word = w.toLowerCase();
            int ind = -1;
            if(map[0].contains(word.charAt(0))) ind = 0;
            else if(map[1].contains(word.charAt(0))) ind = 1;
            else ind = 2;
            int count = 1;
            for(int i=1; i<word.length(); i++){
                if(map[ind].contains(word.charAt(i))) count++;
            }
            if(count==word.length()) list.add(w);
        }
        String[] ans = new String[list.size()];
        int i = 0;
        for(String str: list){
            ans[i++]=str;
        }
        return ans;
    }
}