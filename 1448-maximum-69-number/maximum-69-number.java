class Solution {
    public int maximum69Number (int num) {
        // Stack<Integer> st = new Stack<>();
        // while(num != 0){
        //     st.push(num%10);
        //     num /= 10;
        // }
        String str = Integer.toString(num);
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }
        int x = 0;
        int n = arr.length;
        for(char ch: arr){
            x += Math.pow(10, n-1) * (ch-'0');
            n--;
        }
        return x;
    }
}