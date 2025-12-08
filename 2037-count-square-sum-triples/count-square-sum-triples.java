class Solution {
    public int countTriples(int n) {
        int count = 0;
        for(int i=2; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<=n; k++){
                    if(k*k == j*j + i*i) count++;
                }
            }
        }
        return count*2;
    }
}