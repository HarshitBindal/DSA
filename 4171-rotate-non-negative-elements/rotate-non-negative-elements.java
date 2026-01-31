class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int pos = 0;
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            if(num>=0) list.add(num);
        }
        int[] arr = new int[list.size()];
        int n = arr.length;
        for(int i=0; i<n; i++){
            arr[(i-k%n+n)%n]=list.get(i);
        }
        int[] ans = new int[nums.length];
        int j=0;
        for(int i=0; i<ans.length; i++){
            if(nums[i]<0) ans[i]=nums[i];
            else{
                ans[i]=arr[j];
                j++;
            }
        }
        return ans;
    }
}