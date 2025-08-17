class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long count = 0;
        for(int i=0; i<n; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int j = 0;
        for(int i=0; i<n-1; i++){
            while(j+1<n && nums[j+1]<=2*nums[i]){
                j++;
            }
            count += j-i;
        }
        return count;
        // for(int i=0; i<n-1; i++){
        //     for(int j=i+1; j<n; j++){
        //         int a = nums[i];
        //         int b = nums[j];
        //         if(Math.min(Math.abs(a-b), Math.abs(a+b)) <= Math.min(Math.abs(a), Math.abs(b)) &&
        //         Math.max(Math.abs(a-b), Math.abs(a+b)) >= Math.max(Math.abs(a), Math.abs(b))){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}