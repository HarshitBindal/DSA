class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int total = 0;
        for(int i=0; i<n; i++){
            int[] freq = new int[26];
            for(int j=i; j<n; j++){
                int mini = Integer.MAX_VALUE;
                int maxi = Integer.MIN_VALUE;
                freq[s.charAt(j)-'a']++;
                for(int f:freq){
                    if(f>0){
                        mini = Math.min(mini, f);
                        maxi = Math.max(maxi, f);
                    }
                }
                total += maxi - mini;
            }
        }
        return total;
    }
}