class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        if(n==1) return -1;
        long sum = 0;
        long prod = 1;
        for(int num: nums){
            sum+=num;
            if(num==0) return 0;
        }
        for(int i=n-1; i>=0; i--){
            sum-=nums[i];
            if(sum==prod) return i;
            if(sum<prod) return -1;
            prod*=nums[i];
        }
        return -1;
        // long[] prefix = new long[n];
        // long[] suffix = new long[n];
        // prefix[0]=0;
        // suffix[n-1]=1;
        // for(int i=1; i<n; i++){
        //     prefix[i]=(long)nums[i-1]+prefix[i-1];
        // }
        // for(int i=n-2; i>=0; i--){
        //     suffix[i]=suffix[i+1]*(long)nums[i+1];
        // }
        // print(prefix);
        // print(suffix);
        // for(int i=0; i<n; i++){
        //     if(prefix[i]==suffix[i]) return i;
        // }
        // return -1;
    }
}