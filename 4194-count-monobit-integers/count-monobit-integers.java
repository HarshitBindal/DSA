class Solution {
    public int countMonobit(int n) {
        int cnt=1;
        for(int i=1; i<=n; i=(i<<1)|1){
            cnt++;
        }
        return cnt;
    }
}