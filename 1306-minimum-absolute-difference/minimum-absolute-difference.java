class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] diff = new int[n-1];
        int mini = Integer.MAX_VALUE;
        for(int i=0; i<n-1; i++){
            diff[i]=arr[i+1]-arr[i];
            mini = Math.min(mini, diff[i]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<diff.length; i++){
            if(diff[i]==mini){
                list.add(new ArrayList<>());
                list.get(list.size()-1).add(arr[i]);
                list.get(list.size()-1).add(arr[i+1]);
            } 
        }
        return list;
    }
}