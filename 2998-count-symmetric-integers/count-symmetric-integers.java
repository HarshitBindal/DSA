class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for(int i=low; i<=high; i++){
            String str = String.valueOf(i);
            if((str.length())%2 != 0){
                continue;
            }
            int mid = str.length()/2;
            int left = 0;
            int right = 0;
            for(int j=0; j<mid; j++){
                left += str.charAt(j) - '0';
            }
            for(int j=mid; j<str.length(); j++){
                right += str.charAt(j) - '0';
            }
            if(left == right) ans++;
        }
        return ans;
    }
}