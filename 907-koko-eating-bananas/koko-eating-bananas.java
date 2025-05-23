class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int ans = 0;
        int high = maxElement(piles);
        while(low <= high){
            int mid = low + (high-low)/2;
            int totalhrs = hours(piles, mid);
            if(totalhrs <= h){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    private int hours(int[] piles, int hourly){
        int totalhrs = 0;
        for(int i=0; i<piles.length; i++){
            totalhrs += Math.ceil((double)piles[i]/hourly);
        }
        return totalhrs;
    }
    private int maxElement(int[] piles){
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<piles.length; i++){
            ans = Math.max(ans, piles[i]);
        }
        return ans;
    }
}