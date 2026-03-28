class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashSet<Integer> set = new HashSet<>();
        for(int bulb: bulbs){
            if(set.contains(bulb)) set.remove(bulb);
            else set.add(bulb);
        }
        List<Integer> res = new ArrayList<>();
        for(int val: set){
            res.add(val);
        }
        Collections.sort(res);
        return res;
    }
}