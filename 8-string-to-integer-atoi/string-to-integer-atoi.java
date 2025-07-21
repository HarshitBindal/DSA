class Solution {
    public int myAtoi(String s) {
        String str = s.replaceFirst("^\\s+", "");
        HashSet<Character> set = new HashSet<>();
        for(char i='0'; i<='9'; i++){
            set.add(i);
        }
        boolean neg = false;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(i==0){
                if(ch == '-') {
                    neg = true;
                } else if(ch == '+') continue;
                else if(!set.contains(ch)) return 0;
                else sb.append(ch);
            }
            else if(!set.contains(ch)){
                break;
            }
            else {
                sb.append(ch);
            }
        }
        if(sb.isEmpty()) return 0;
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString());
        } catch(NumberFormatException e) {
            return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return neg? -ans: ans;
    }
}