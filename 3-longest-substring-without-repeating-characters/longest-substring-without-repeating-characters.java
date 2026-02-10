class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int maxlen = 0;
        int i=0,j=0;
        while(i<n && j<n){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                maxlen = Math.max(maxlen, j-i+1);
                set.add(ch);
                System.out.println(ch);
                j++;
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return maxlen;
    }
}