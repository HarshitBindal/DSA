class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows == 1 || numRows>n) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++){
            rows[i] = new StringBuilder();
        }
        boolean down = true;
        int curr = 0;
        for(char ch : s.toCharArray()){
            rows[curr].append(ch);
            if(curr == 0) down = true;
            else if(curr == numRows-1) down = false;
            if(!down) curr--;
            else if(down) curr++;
        }
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<numRows; i++){
            sb.append(rows[i]);
        }
        return sb.toString();

    }
}