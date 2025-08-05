class Solution {
    public List<String> letterCombinations(String digits) {
        
        HashMap<Integer, Character[]> map = new HashMap<>();
        map.put(2, new Character[]{'a', 'b', 'c'});
        map.put(3, new Character[]{'d', 'e', 'f'});
        map.put(4, new Character[]{'g', 'h', 'i'});
        map.put(5, new Character[]{'j', 'k', 'l'});
        map.put(6, new Character[]{'m', 'n', 'o'});
        map.put(7, new Character[]{'p', 'q', 'r', 's'});
        map.put(8, new Character[]{'t', 'u', 'v'});
        map.put(9, new Character[]{'w', 'x', 'y', 'z'});

        if(digits.length()==0 || digits==null) return new ArrayList<>();
        int[] digit = new int[digits.length()];
        for(int i=0; i<digits.length(); i++){
            digit[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        List<Character[]> alphas = new ArrayList<>();
        for(int i: digit){
            alphas.add(map.get(i));
        }
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), alphas, 0);
        return res;
    }
    private void helper(List<String> res, StringBuilder sb, List<Character[]> alphas,
    int i){
        if(i == alphas.size()){
            res.add(new StringBuilder(sb).toString());
            return;
        }
        Character[] letters = alphas.get(i);
        for(char ch: letters){
            sb.append(ch);
            helper(res, sb, alphas, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}