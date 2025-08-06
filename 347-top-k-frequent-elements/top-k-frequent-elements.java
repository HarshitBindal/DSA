class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        ArrayList<Integer>[] freq = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for(int i=0; i<=n; i++){
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> set: map.entrySet()){
            freq[set.getValue()].add(set.getKey());
        }
        List<Integer> count = new ArrayList<>();
        for(int i=n; i>=0 && count.size()<k; i--){
            for(int num: freq[i]){
                count.add(num);
                if(count.size()==k) break;
            }
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = count.get(i);
        }
        return res;
    }
}