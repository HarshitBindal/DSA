class Solution {
    public String clearStars(String s) {
        TreeMap<Character, Stack<Integer>> map = new TreeMap<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '*'){
                char small = map.firstKey();
                int idx = map.get(small).pop();
                arr[idx] = '*';
                if(map.get(small).isEmpty()){
                    map.remove(small);
                }
            }
            else {
                map.putIfAbsent(arr[i], new Stack<Integer>());
                map.get(arr[i]).push(i);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<n; i++){
            if(arr[i] != '*'){
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}