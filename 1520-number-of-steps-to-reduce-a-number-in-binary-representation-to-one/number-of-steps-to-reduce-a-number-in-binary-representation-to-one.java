import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        BigInteger x = new BigInteger(s, 2);
        int cnt=0;
        while(!x.equals(BigInteger.ONE)){
            if(x.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
                x=x.divide(BigInteger.TWO);
            }
            else x=x.add(BigInteger.ONE);
            cnt++;
        }
        return cnt;
    }
}