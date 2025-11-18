class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while(i<n-1){
            i += 1 + bits[i];
        }
        return i==n-1;
    }        
}