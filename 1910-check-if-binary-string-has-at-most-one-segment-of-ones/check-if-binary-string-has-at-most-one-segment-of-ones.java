class Solution {
    public boolean checkOnesSegment(String s) {
        int n =s.length();
        int lastOne=0;
        for(int i=1; i<n; i++){
            if(s.charAt(i)=='1'){
                if(i-lastOne>1) return false;
                lastOne=i;
            }
        }
        return true;
    }
}