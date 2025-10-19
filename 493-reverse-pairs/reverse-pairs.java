class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int low, int high){
        if(low>=high) return 0;
        int mid = low + (high-low)/2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid+1, high);
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        return count;
    }
    private int countPairs(int[] nums, int low, int mid, int high){
        int count = 0;
        int right = mid+1;
        for(int i=low; i<=mid; i++){
            while(right<=high && (long)nums[i]>2*(long)(nums[right])){
                right++;
            }
            count += right - (mid+1);
        }
        return count;
    }
    public void merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        List<Integer> list = new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                list.add(nums[left]);
                left++;
            }
            else{
                list.add(nums[right]);
                right++;
            }
        }
        while(left<=mid){
            list.add(nums[left]);
            left++;
        }
        while(right<=high){
            list.add(nums[right]);
            right++;
        }
        for(int i=low; i<=high; i++){
            nums[i] = list.get(i-low);
        }
    }
}