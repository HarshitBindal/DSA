class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n*2; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]){
                ans[st.pop()] = nums[i%n];
            }
            if(i<n) st.push(i);
        }
        return ans;
    }
}