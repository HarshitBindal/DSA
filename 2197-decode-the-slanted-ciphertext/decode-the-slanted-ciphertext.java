class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;
        char[][] mat = new char[rows][cols];
        int ind = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                mat[i][j] = encodedText.charAt(ind);
                ind++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0; k<cols; k++){
            int i=0;
            int j=k;
            while(i<rows && j<cols){
                sb.append(mat[i][j]);
                i++;
                j++;
            }
        }
        int end = sb.length()-1;
        while(end>=0 && sb.charAt(end)==' '){
            end--;
        }
        return sb.substring(0,end+1);
    }
}