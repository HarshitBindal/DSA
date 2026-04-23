class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        long[] res = new long[n];
        for(List<Integer> arr: map.values()){
            int size = arr.size();
            long[] pref = new long[size];
            pref[0]=arr.get(0);
            for(int i=1; i<size; i++){
                pref[i]=pref[i-1]+arr.get(i);
            }
            for(int i=0; i<size; i++){
                long left=0, right=0;
                if(i>0){
                    left = (long)i * arr.get(i)-pref[i-1];
                }
                if(i<size-1){
                    right = (pref[size-1]-pref[i])-(long)(size-i-1)*arr.get(i);
                }
                res[arr.get(i)] = left+right;
            }
        }
        return res;
    }
}