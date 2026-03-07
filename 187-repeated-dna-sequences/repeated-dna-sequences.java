class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n<10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> added = new HashSet<>();
        List<String> res = new ArrayList<>();
        for(int i=0; i<=n-10; i++){
            String str = s.substring(i,i+10);
            if(!set.contains(str)) set.add(str);
            else if(!added.contains(str)){
                res.add(str);
                added.add(str);
            } 
        }
        return res;
    }
}