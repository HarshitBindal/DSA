class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] yes = new int[n+1];
        int[] no = new int[n+1];
        for(int i=n-1; i>=0; i--){
            if(customers.charAt(i)=='Y'){
                yes[i] = yes[i+1] + 1;
            } else yes[i]=yes[i+1];
        }
        for(int i=1; i<=n; i++){
            if(customers.charAt(i-1)=='N'){
                no[i]=no[i-1]+1;
            } else no[i]=no[i-1];
        }
        int minPen = n+1;
        int idx = -1;
        for(int i=0; i<=n; i++){
            int penalty = yes[i]+no[i];
            if(penalty<minPen){
                minPen = penalty;
                idx = i;
            }
        }
        return idx;
    }
}