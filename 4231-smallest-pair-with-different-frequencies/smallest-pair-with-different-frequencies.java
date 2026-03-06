class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int len = map.size();
        int ind=0;
        int[] arr = new int[len];
        for(int val: map.keySet()){
            arr[ind++]=val;
        }
        Arrays.sort(arr);
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if(map.get(arr[i])!=map.get(arr[j])){
                    return new int[]{arr[i],arr[j]};
                } 
            }
        }
        return new int[]{-1,-1};
    }
}