class Solution {
    public long minCost(String s, int[] cost) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.putIfAbsent(ch, new ArrayList<>());
            map.get(ch).add(cost[i]);
        }
        long maxi = 0;
        long total = 0;
        for(Map.Entry<Character, List<Integer>> entry: map.entrySet()){
            List<Integer> list = entry.getValue();
            long sum = 0;
            for(int x: list){
                sum += x;
            }
            maxi = Math.max(maxi, sum);
            total += sum;
        }
        return total-maxi;
    }
}