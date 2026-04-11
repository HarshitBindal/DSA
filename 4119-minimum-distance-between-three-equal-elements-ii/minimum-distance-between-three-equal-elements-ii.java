class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        int mini = Integer.MAX_VALUE;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            List<Integer> list = entry.getValue();
            if(list.size()>=3){
                print(list);
                Collections.sort(list);
                int i=0, j=1, k=2;
                while(k<list.size()){
                    int sum = Math.abs(list.get(i)-list.get(j))+Math.abs(list.get(k)-list.get(j))+Math.abs(list.get(i)-list.get(k));
                    mini = Math.min(mini, sum);
                    i++;
                    j++;
                    k++;
                }
            }
        }
        return mini==Integer.MAX_VALUE? -1: mini;
    }
    private void print(List<Integer> list){
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}