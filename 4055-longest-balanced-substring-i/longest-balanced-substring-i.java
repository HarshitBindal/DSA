class Solution {
    public int longestBalanced(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int max = 0;
        for(int i=0; i<n; i++){
            map.clear();
            for(int j=i; j<n; j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                if(isSameFreq(map, map.get(s.charAt(j)))){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    private boolean isSameFreq(HashMap<Character, Integer> map, int freq){
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue()!=freq) return false;
        }
        return true;
    }
}