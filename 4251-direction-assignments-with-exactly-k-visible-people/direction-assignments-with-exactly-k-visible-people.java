class Solution {
    int mod = (int)1e9 + 7;
    long[] fact, inv;
    public int countVisiblePeople(int n, int pos, int k) {
        int a = pos;
        int b = n-pos-1;
        long ans = 0;
        initialise(n);
        for(int i=Math.max(0,k-b); i<=Math.min(a, k); i++){
            long x = (C(a, i)*C(b, k-i))%mod;
            ans = (ans+x)%mod;
        }
        return (int)((ans*2)%mod);
    }
    private void initialise(int n){
        fact = new long[n+1];
        inv = new long[n+1];
        fact[0]=1;
        for(int i=1; i<=n; i++){
            fact[i]= (fact[i-1]*i)%mod;
        }
        inv[n]=pow(fact[n], mod-2);
        for(int i=n-1; i>=0; i--){
            inv[i]= (inv[i+1]*(i+1))%mod;
        }
    }
    private long C(int n, int r){
        return (((fact[n]*inv[r])%mod)*inv[n-r])%mod;
    }
    private long pow(long a, long b){
        long res = 1;
        while(b>0){
            if((b&1)==1) res = (res*a)%mod;
            a = (a*a)%mod;
            b >>= 1;
        }
        return res;
    }
}