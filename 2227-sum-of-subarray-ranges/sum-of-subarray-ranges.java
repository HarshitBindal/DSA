class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long totalmin = 0;
        long totalmax = 0;
        // minimum
        int[] nextsmall = nse(nums);
        int[] prevsmall = psee(nums);
        for(int i=0; i<n; i++){
            long left = i-prevsmall[i];
            long right = nextsmall[i]-i;
            totalmin += (long)(left*right*nums[i]);
        }
        // maximum
        int[] prevgreat = pgee(nums);
        int[] nextgreat = nge(nums);
        for(int i=0; i<n; i++){
            long left = i-prevgreat[i];
            long right = nextgreat[i]-i;
            totalmax += (long)(left*right*nums[i]);
        }
        return totalmax-totalmin;
    }
    private int[] nse(int[] nums){
        int[] arr = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            arr[i] = st.isEmpty()? nums.length: st.peek();
            st.push(i);
        }
        return arr;
    }
    private int[] nge(int[] nums){
        int[] arr = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            arr[i] = st.isEmpty()? nums.length: st.peek();
            st.push(i);
        }
        return arr;
    }
    // previous smaller or equal element
    private int[] psee(int[] nums){
        int[] arr = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            arr[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        return arr;
    }
    // previous greater or equal element
    private int[] pgee(int[] nums){
        int[] arr = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            arr[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        return arr;
    }
}