class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x: hand){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        int[] unique = new int[map.size()];
        int j = 0;
        for(int key: map.keySet()){
            unique[j++] = key;
        }
        Arrays.sort(unique);
        for(int key: unique){
            int start = map.get(key);
            if(map.get(key)>0){
                for(int i=key; i<key+groupSize; i++){
                    if(map.getOrDefault(i,0)<start) return false;
                    map.put(i, map.get(i)-start);
                }
            }
        }
        return true;
    }
}