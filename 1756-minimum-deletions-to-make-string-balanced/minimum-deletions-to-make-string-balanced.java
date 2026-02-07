class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] b = new int[n];
        int[] a = new int[n];
        b[0]=0;
        a[n-1]=0;
        for(int i=1; i<n; i++){
            b[i]=b[i-1];
            if(s.charAt(i-1)=='b') b[i]=b[i-1]+1;
        }
        for(int i=n-2; i>=0; i--){
            a[i]=a[i+1];
            if(s.charAt(i+1)=='a') a[i]=a[i+1]+1;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.min(ans, Math.abs(a[i]+b[i]));
        }
        return ans;
    }
}