class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxi = 0;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = cardPoints[0];
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + cardPoints[i];
        }
        suffix[n-1] = cardPoints[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = suffix[i+1] + cardPoints[i];
        }
        for(int i=k; i>=0; i--){
            int sum = 0;
            if(i==k) sum = prefix[i-1];
            else if(i==0) sum = suffix[n-k+i];
            else sum = prefix[i-1] + suffix[n-k+i];
            maxi = Math.max(maxi, sum);
        }
        return maxi;

        // for(int x=k; x>=0; x--){
        //     int sum = 0;
        //     for(int y=x-1; y>=0; y--){
        //         sum += cardPoints[y];
        //     }
        //     for(int z=n-k+x; z<n; z++){
        //         sum += cardPoints[z];
        //     }
        //     maxi = Math.max(maxi, sum);
        // }
        // return maxi;
    }
}