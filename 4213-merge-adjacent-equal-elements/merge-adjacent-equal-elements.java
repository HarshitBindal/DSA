class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> res = new ArrayList<>();
        for(long num: nums){
            res.add(num);
            while(res.size()>1 && res.get(res.size()-1).equals(res.get(res.size()-2))){
                long x = res.get(res.size()-1);
                res.remove(res.size()-1);
                res.remove(res.size()-1);
                res.add(2*x);
            }
        }
        return res;
    }
}