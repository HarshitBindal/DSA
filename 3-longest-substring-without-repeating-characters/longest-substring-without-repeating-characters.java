class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int maxlen=0;
        int i=0,j=0;
        while(i<n && j<n){
            if(!set.contains(s.charAt(j))){
                maxlen = Math.max(maxlen, j-i+1);
                set.add(s.charAt(j));
                System.out.println(s.charAt(j));
                j++;
            }
            else{
                System.out.print("removed ");
                System.out.println(s.charAt(i));
                set.remove(s.charAt(i));
                i++;
            }
        }
        return maxlen;
    }
}