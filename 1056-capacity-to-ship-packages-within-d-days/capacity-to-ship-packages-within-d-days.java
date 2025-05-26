class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        for(int i=0; i<weights.length; i++){
            low = Math.max(low, weights[i]);
        }
        int high = sum(weights);
        while(low <= high){
            int mid = low + (high-low)/2;
            if(feasible(weights, mid, days)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private int sum(int[] weights){
        int total = 0;
        for(int wt : weights){
            total += wt;
        }
        return total;
    }
    private boolean feasible(int[] weights, int capacity, int days){
        int load = 0, reqDays = 1;
        for(int wt : weights){
            if(wt + load <= capacity){
                load += wt;
            } else {
                reqDays++;
                load = wt;
            }
        }
        return reqDays <= days;
    }
}