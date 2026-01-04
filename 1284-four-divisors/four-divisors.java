class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for(int num: nums){
            int[] curr = divisors(num);
            if(curr[1]==4){
                ans+=curr[0];
            }
        }
        return ans;
    }
    private int[] divisors(int num){
        if(num == 1) return new int[]{1,1};
        int count = 0;
        int sum = 0;
        for(int i=1; i*i<=num; i++){
            if(num%i==0){
                sum += i;
                sum += num/i;
                if(num/i==i){
                    count++;
                    sum -= i;
                } 
                else count+=2;
            }
        }
        return new int[]{sum,count};
    }
}