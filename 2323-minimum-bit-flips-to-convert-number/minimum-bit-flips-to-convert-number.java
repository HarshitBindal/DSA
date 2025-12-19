class Solution {
    public int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        int x = 1;
        int ans = 0;
        while(x<=res){
            if((x & res) != 0) ans++;
            x = x<<1;
        }
        return ans;
    }
}