class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<s.length()-k+1; i++){
            String substr = s.substring(i,i+k);
            if(!set.contains(substr)){
                set.add(substr);
            }
        }
        return set.size()==Math.pow(2,k)? true: false;
    }
}