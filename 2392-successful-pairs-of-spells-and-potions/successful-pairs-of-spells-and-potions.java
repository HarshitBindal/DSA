class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        // success -> spell[i]*potion[j]>=success
        // return pair length n -> pairs[i] potion form successful pair
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for(int i=0; i<n; i++){
            pairs[i] = m-search(spells[i], potions, success);
        }
        return pairs;

    }
    private int search(int spell, int[] potions, long success){
        int start = 0;
        int end = potions.length-1;
        int prev = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if((long)potions[mid]*(long)spell>=success){
                prev = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
                prev = start;
            }
        }
        return prev;
    }
}