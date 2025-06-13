class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        helper(s, list, new ArrayList<>(), 0);
        return list;
    }
    private void helper(String s, List<List<String>> list, List<String> path, int i){
        if(i==s.length()){
            list.add(new ArrayList<>(path));
            return;
        } 
        for(int j=i+1; j<=s.length(); j++){
            if(palindrome(s.substring(i, j))) {
                path.add(s.substring(i, j));
                helper(s, list, path, j);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean palindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<=j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}