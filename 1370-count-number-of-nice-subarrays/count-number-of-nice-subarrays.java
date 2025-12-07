class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            if((nums[i] & 1)==1) arr[i] = 1;
        }
        return sumOfGoal(arr, k) - sumOfGoal(arr, k-1);
    }
    private int sumOfGoal(int[] arr, int k){
        if(k<0) return 0;
        int n = arr.length;
        int l = 0, r = 0, count = 0;
        int sum = 0;
        while(r<n){
            sum += arr[r];
            while(l<n && sum>k){
                sum -= arr[l];
                l++;
            }
            count += r-l+1;
            r++;
        }
        return count;
    }
}