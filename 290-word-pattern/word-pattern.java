class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashSet<String> set = new HashSet<>();
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            char ch = pattern.charAt(i);
            String word = arr[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(word)) return false;
            } else {
                if(set.contains(word)) return false;
            }
            map.put(ch, word);
            set.add(word);
        }
        return true;
    }
}