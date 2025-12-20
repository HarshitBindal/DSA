class Solution {
    public int countPrimes(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        for(int i=2; i<=n/2; i++){
            if(arr[i]==1){
                int j = 2;
                while(i*j<=n){
                    arr[i*j]=0;
                    j++;
                }
            }
        }
        int count = 0;
        for(int i=2; i<n; i++){
            if(arr[i]==1) count++;
        }
        return count;
    }
}