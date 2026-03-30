class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        HashMap<Character, Integer> odd = new HashMap<>();
        HashMap<Character, Integer> even = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = s1.charAt(i);
            if(i%2!=0) odd.put(ch, odd.getOrDefault(ch,0)+1);
            else even.put(ch, even.getOrDefault(ch,0)+1);
        }
        for(int i=1; i<n; i+=2){
            char ch = s2.charAt(i);
            if(!odd.containsKey(ch)) return false;
            if(odd.containsKey(ch)){
                odd.put(ch, odd.get(ch)-1);
                if(odd.get(ch)==0) odd.remove(ch);
            }
        }
        for(int i=0; i<n; i+=2){
            char ch = s2.charAt(i);
            if(!even.containsKey(ch)) return false;
            if(even.containsKey(ch)){
                even.put(ch, even.get(ch)-1);
                if(even.get(ch)==0) even.remove(ch);
            }
        }
        return true;
    }
}