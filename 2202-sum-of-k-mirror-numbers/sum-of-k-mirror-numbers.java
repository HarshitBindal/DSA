class Solution {
    public long kMirror(int k, int n) {
        int l = 1;
        long sum = 0;
        while(n > 0){
            long halfpower = (l+1)/2;
            long min_num = (long)Math.pow(10, halfpower-1);
            long max_num = (long)Math.pow(10, halfpower) - 1;
            for(long num=min_num; num<=max_num; num++){
                String firsthalf = String.valueOf(num);
                String sechalf = new StringBuilder(firsthalf).reverse().toString();
                String full_pali;
                if(l%2 == 0){
                    full_pali = firsthalf + sechalf;
                } else {
                    full_pali = firsthalf + sechalf.substring(1);
                }
                String basek = tobasek(Long.parseLong(full_pali), k);
                if(palindrome(basek)){
                    sum += Long.parseLong(full_pali);
                    n--;
                    if(n==0) return sum;
                }
            }
            l++;
        }
        return sum;
    }
    private String tobasek(long num, int k){
        StringBuilder sb = new StringBuilder("");
        while(num > 0){
            sb.append(num%k);
            num /= k;
        }
        return sb.reverse().toString();
    }
    private boolean palindrome(String s){
        if(s.length() == 1) return true;
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}