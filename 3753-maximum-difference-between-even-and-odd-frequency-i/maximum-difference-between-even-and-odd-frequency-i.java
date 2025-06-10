class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) map.put(ch, map.get(ch)+1);
            else map.put(ch, 1);
        }

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int val : map.values()){
            if(val%2 == 0) even.add(val);
            else odd.add(val);
        }
        int oddm = Integer.MIN_VALUE;
        int evenm = Integer.MAX_VALUE;
        for(int i=0; i<odd.size(); i++){
            oddm = Math.max(oddm, odd.get(i));
        }
        for(int i=0; i<even.size(); i++){
            evenm = Math.min(evenm, even.get(i));
        }
        return oddm - evenm;
    }
}