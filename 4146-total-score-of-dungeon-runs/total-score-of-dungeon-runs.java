class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] prefix = new long[n+1];
        long ans = 0;
        for(int i=1; i<=n; i++){
            prefix[i]=prefix[i-1]+damage[i-1];
        }
        for(int i=1; i<=n; i++){
            long target = prefix[i]+requirement[i-1]-(long)hp;
            int it = lower_bound(prefix, target);
            if(it<=i-1) ans+=(i-it);
        }
        return ans;
    }
    private int lower_bound(long[] prefix, long target){
        int s=0, e=prefix.length-1;
        while(s<e){
            int mid = s + (e-s)/2;
            if(prefix[mid]<target){
                s=mid+1;
            } else e= mid;
        }
        return s;
    }
}