class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr){
            set.add(num);
        }
        int start = 1;
        int end = arr[arr.length-1];
        int c = 0;
        while(start<=end){
            if(!set.contains(start)){
                k--;
                if(k==0) return start;
            }
            start++;
        }
        return end+k;
    }
}