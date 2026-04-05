class Solution {
    public int mirrorFrequency(String s) {
        int n = s.length();
        HashMap<Character, Integer> chars = new HashMap<>();
        // HashMap<character,  Integer> nums = new HashMap<>();
        boolean[] charsVis = new boolean[26];
        boolean[] numsVis = new boolean[10];
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            chars.put(ch, chars.getOrDefault(ch,0)+1);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                if(!numsVis[ch-'0']){
                    char flip = (char)('0'+'9'-ch);
                    ans += Math.abs(chars.getOrDefault(flip,0)-chars.getOrDefault(ch,0));
                    numsVis[ch-'0']=true;
                    numsVis[flip-'0']=true;
                }
            }
            else {
                if(!charsVis[ch-'a']){
                    char flip = (char)('a'+'z'-ch);
                    ans += Math.abs(chars.getOrDefault(flip,0)-chars.getOrDefault(ch,0));
                    charsVis[ch-'a']=true;
                    charsVis[flip-'a']=true;
                }
            }
        }
        return ans;
    }
}