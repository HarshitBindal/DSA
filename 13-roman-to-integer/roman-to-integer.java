class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I',1, 'V',5, 'X',10, 'L',50, 
        'C',100, 'D',500, 'M',1000);
        int n = s.length();
        int res = 0;
        for(int i=0; i<n; i++){
            int curr = map.get(s.charAt(i));
            int next = (i+1 < n)? map.get(s.charAt(i+1)):0;
            if(next>curr) res -= curr;
            else res += curr;
        }
        return res;
    }
}