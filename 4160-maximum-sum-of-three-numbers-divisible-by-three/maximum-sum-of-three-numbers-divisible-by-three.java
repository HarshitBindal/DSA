class Solution {
    public int maximumSum(int[] nums) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        for(int num: nums){
            if(num%3 == 0) a.add(num);
            else if(num%3 == 1) b.add(num);
            else c.add(num);
        }
        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b, Collections.reverseOrder());
        Collections.sort(c, Collections.reverseOrder());
        int ans = 0;
        if(a.size()>=3){
            ans = Math.max(ans, a.get(0)+a.get(1)+a.get(2));
        }
        if(b.size()>=3){
            ans = Math.max(ans, b.get(0)+b.get(1)+b.get(2));
        }
        if(c.size()>=3){
            ans = Math.max(ans, c.get(0)+c.get(1)+c.get(2));
        }
        if(a.size()>=1 && b.size()>=1 && c.size()>=1) {
            ans = Math.max(ans, a.get(0)+b.get(0)+c.get(0));
        }
        return ans;
    }
}