class Solution {
    public int longestConsecutive(int[] nums) {
        int[] arr = removeDup(nums);
        int maxi = 0;
        int count = 0;
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            if(arr[i+1]-arr[i] == 1) {
                count++;
                maxi = Math.max(maxi, count);
            }
            else count = 0;
        }
        return arr.length==0? 0: maxi+1;
    }
    private int[] removeDup(int[] nums){
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();
        if(nums.length>0) list.add(nums[0]);
        for(int num: nums){
            if(list.get(list.size()-1) != num) list.add(num);
        }
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}