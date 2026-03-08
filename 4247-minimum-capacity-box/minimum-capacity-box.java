class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n = capacity.length;
        int cap=Integer.MAX_VALUE;
        int ind=-1;
        for(int i=0; i<n; i++){
            if(capacity[i]>=itemSize && cap>capacity[i]){
                ind=i;
                cap=capacity[i];
            }
        }
        return ind;
    }
}