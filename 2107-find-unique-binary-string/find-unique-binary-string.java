class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(String num: nums){
            set.add(Integer.parseInt(num, 2));
        }
        for(int i=0; i<(1<<n); i++){
            if(!set.contains(i)){
                String str = Integer.toBinaryString(i);
                while(str.length()<n){
                    str = "0"+str;
                }
                return str;
            }
        }
        return "";
    }
}