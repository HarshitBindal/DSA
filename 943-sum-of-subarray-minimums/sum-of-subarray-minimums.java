class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        int total = 0;
        int[] prev = psee(arr);
        int[] next = nse(arr);
        for(int i=0; i<n; i++){
            int left = i-prev[i];
            int right = next[i]-i;
            total = (int)((total + ((long)left*right%mod*arr[i])%mod)%mod);
        }
        return total;
    }
    private int[] nse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            nse[i] = st.isEmpty()? n: st.peek();
            st.push(i);
        }
        return nse;
    }
    // previous smaller or equal element
    private int[] psee(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] psee = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            psee[i] = st.isEmpty()? -1: st.peek();
            st.push(i);
        }
        return psee;
    }
}