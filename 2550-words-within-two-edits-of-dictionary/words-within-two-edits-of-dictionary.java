class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        int n = queries.length;
        int m = dictionary.length;
        List<String> list = new ArrayList<>();
        // HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(same(queries[i],dictionary[j])){
                    // set.add(queries[i]);
                    list.add(queries[i]);
                    break;
                }
            }
        }
        return list;
    }
    private boolean same(String s1, String s2){
        int cnt = 0;
        int i=0;
        while(i<s1.length()){
            if(s1.charAt(i)!=s2.charAt(i)){
                cnt++;
            }
            if(cnt>2) return false;
            i++;
        }
        return true;
    }
}