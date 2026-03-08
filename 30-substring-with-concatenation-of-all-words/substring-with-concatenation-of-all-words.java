class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int m = words[0].length();
        int len = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word: words){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for(int offset=0; offset<m; offset++){
            int i=offset;
            int cnt=0;
            HashMap<String, Integer> window = new HashMap<>();
            for(int j=offset; j+m<=n; j+=m){
                String str = s.substring(j,j+m);
                if(map.containsKey(str)){
                    window.put(str, window.getOrDefault(str,0)+1);
                    cnt++;
                    while(window.get(str)>map.get(str)){
                        String left = s.substring(i,i+m);
                        window.put(left, window.get(left)-1);
                        i+=m;
                        cnt--;
                    }
                    if(cnt==len) res.add(i);
                }
                else {
                    cnt=0;
                    window.clear();
                    i=j+m;
                }
            }
        }
        return res;
    }
}