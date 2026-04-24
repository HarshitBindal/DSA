class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int left = 0, right = 0, blank = 0;
        for(int i=0; i<n; i++){
            if(moves.charAt(i)=='L') left++;
            else if(moves.charAt(i)=='R') right++;
            else blank++;
        }
        return Math.abs(left-right)+blank;
    }
}