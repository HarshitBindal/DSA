class Solution {
    public int reverse(int x) {
        boolean negative = x<0;
        long val = Math.abs((long)x);
        Queue<Integer> q = new LinkedList<>();
        while(val != 0){
            q.offer((int)(val % 10));
            val /= 10;
        }
        int ans = 0;
        while(!q.isEmpty()){
            int digit = q.poll();
            if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && digit>7)){
                return 0;
            }
            ans = ans*10 + digit;
        }
        if(negative) return -ans;
        return ans;
    }
}