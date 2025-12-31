class Solution {
    public String countAndSay(int n) {
        StringBuilder sb  = new StringBuilder("");
        if(n==1) return "1";
        String str = "1";
        int count = 1;
        while(count<n){
            int i=0;
            sb.delete(0, sb.length());
            int len = str.length();
            while(i<len){
                int j=i;
                while(j<len && str.charAt(j)==str.charAt(i)){
                    j++;
                }
                sb.append(Integer.toString(j-i).charAt(0));
                sb.append(str.charAt(j-1));
                i=j;
            }
            str = sb.toString();
            count++;
        }
        return sb.toString();
    }
}