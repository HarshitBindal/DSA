class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;
        boolean[] sorted = new boolean[n-1];
        for(int i=0; i<m; i++){
            boolean delete = false;
            for(int j=0; j<n-1; j++){
                if(!sorted[j] && strs[j].charAt(i)>strs[j+1].charAt(i)){
                    delete = true;
                    break;
                }
            }
            if(delete) {
                count++;
                continue;
            }
            for(int k=0; k<n-1; k++){
                if(!sorted[k] && strs[k].charAt(i)<strs[k+1].charAt(i)){
                    sorted[k]=true;
                }
            }
        }
        return count;
    }
}