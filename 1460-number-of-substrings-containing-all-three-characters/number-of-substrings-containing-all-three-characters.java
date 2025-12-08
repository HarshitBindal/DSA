class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastseen = new int[3];
        Arrays.fill(lastseen, -1);
        int count = 0;
        for(int i=0; i<s.length(); i++){
            lastseen[s.charAt(i)-'a'] = i;
            if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
                int ind = Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2]));
                count += ind+1;
            }
        }
        return count;
    }
}