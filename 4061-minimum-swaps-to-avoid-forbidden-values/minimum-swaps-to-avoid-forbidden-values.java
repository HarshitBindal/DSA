class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        for(int i=0;  i<n; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
            freq.put(forbidden[i], freq.getOrDefault(forbidden[i],0)+1);
            if(freq.get(nums[i])>=n+1) return -1;
            if(freq.get(forbidden[i])>=n+1) return -1;
        }
        int bad = 0;
        HashMap<Integer, Integer> cntbad = new HashMap<>();
        for(int i=0; i<n; i++){
            if(nums[i]==forbidden[i]){
                bad++;
                int x = nums[i];
                cntbad.put(x, cntbad.getOrDefault(x, 0)+1);
            }
        }
        if(bad==0) return 0;
        int maxfreq = 0;
        for(int x: cntbad.values()){
            maxfreq = Math.max(x, maxfreq);
        }
        return Math.max((bad+1)/2, maxfreq);
    }
}