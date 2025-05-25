class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k > bloomDay.length){
            return -1;
        }

        int x = Integer.MIN_VALUE;
        int y = Integer.MAX_VALUE;
        for(int day : bloomDay){
            x = Math.max(x, day);
            y = Math.min(y, day);
        }

        int low = y;
        int high = x;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay, mid, m, k)){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
    private boolean possible(int[] bloomDay, int mid, int m, int k){
        int count = 0;
        int bou = 0;
        for(int day : bloomDay){
            if(day <= mid){
                count++;
                if(count == k){
                    count = 0;
                    bou++;
                }
            } else {
                count = 0;
            }
        }
        return bou>=m;
    }
}