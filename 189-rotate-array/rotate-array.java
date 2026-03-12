class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        k=k%n;
        for(int i=n-k; i<n; i++){
            res.add(nums[i]);
        }
        for(int i=0; i<n-k; i++){
            res.add(nums[i]);
        }
        for(int i=0; i<n; i++){
            nums[i]=res.get(i);
        }
    }
}