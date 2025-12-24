class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b)->a[0]-b[0]);
        int n = events.length;
        int[] suffix = new int[n];
        suffix[n-1] = events[n-1][2];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.max(suffix[i+1], events[i][2]);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            int l = i+1;
            int r = n-1;
            int value = events[i][2];
            int ind = -1;
            while(l<=r){
                int mid = l + (r-l)/2;
                if(events[mid][0]>events[i][1]){
                    ind = mid;
                    r = mid-1;
                } else l = mid+1;
            }
            if(ind!=-1) value += suffix[ind];
            ans = Math.max(ans, value);
        }
        return ans;
    }
}