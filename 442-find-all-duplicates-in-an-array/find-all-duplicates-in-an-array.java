class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[nums[i]]++;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2) res.add(i);
        }
        return res;
    }
}