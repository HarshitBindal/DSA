class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("electronics", 0);
        map.put("grocery", 1);
        map.put("pharmacy", 2);
        map.put("restaurant", 3);
        List<String> list = new ArrayList<>();
        List<Integer> valid = new ArrayList<>();
        for(int i=0; i<code.length; i++){
            if(code[i].matches("^[a-zA-Z0-9_]+$") && isActive[i] &&
            map.containsKey(businessLine[i])){
                valid.add(i);
            }
        }
        Collections.sort(valid, (i, j)->{
            int p1 = map.get(businessLine[i]);
            int p2 = map.get(businessLine[j]);
            if(p1!=p2){
                return p1-p2;
            }
            return code[i].compareTo(code[j]);
        });
        for(int ind: valid){
            list.add(code[ind]);
        }
        return list;
    }
}