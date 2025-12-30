class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long pairs = Math.min(need1, need2);
        long remaining1 = need1-pairs;
        long remaining2 = need2-pairs;
        long paircost = Math.min(cost1+cost2, costBoth);
        return pairs*paircost + remaining1*Math.min(cost1, costBoth) +
        remaining2*Math.min(cost2, costBoth);
    }
}