class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = (int)Math.ceil((double)s.length()/k);
        String[] arr = new String[n];
        int count = 0;
        for(int i=0; i<s.length(); i+=k){
            StringBuilder sb = new StringBuilder("");
            for(int j=i; j<i+k; j++){
                if(j >= s.length()){
                    sb.append(fill);
                } else {
                    sb.append(s.charAt(j));
                }
            }
            arr[count++] = sb.toString();
        }
        return arr;
    }
}