class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        int n = queries.length;
        for(int i=0; i<n; i++){
            int num = nums[queries[i]];
            List<Integer> list = map.get(num);
            if(list.size()==1) {
                res.add(-1);
                continue;
            }
            int ind = Collections.binarySearch(list, queries[i]);
            int left = (ind-1+list.size())%list.size();
            int right = (ind+1)%list.size();
            int leftDist = Math.abs(list.get(ind)-list.get(left));
            int rightDist = Math.abs(list.get(right)-list.get(ind));
            leftDist = Math.min(leftDist, nums.length-leftDist);
            rightDist = Math.min(rightDist, nums.length-rightDist);
            res.add(Math.min(leftDist, rightDist));
        }
        return res;
    }
}