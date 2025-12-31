class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        int n = strs.length;
        HashMap<String, List<Integer>> map = new HashMap<>();
        String[] arr = new String[n];
        for(int i=0; i<n; i++){
            String str = strs[i];
            char[] curr = str.toCharArray();
            Arrays.sort(curr);
            String sorted = new String(curr);
            if(map.containsKey(sorted)) map.get(sorted).add(i);
            else{
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(i);
            }
        }
        for(Map.Entry<String, List<Integer>> entry: map.entrySet()){
            List<Integer> indices = entry.getValue();
            List<String> temp = new ArrayList<>();
            for(int i: indices){
                temp.add(strs[i]);
            }
            list.add(temp);
        }
        return list;
    }
}