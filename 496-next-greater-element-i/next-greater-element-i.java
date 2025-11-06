class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i], i);
        }
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++){
            int ind = map.get(nums1[i]);
            for(int greater=ind+1; greater<nums2.length; greater++){
                if(nums2[greater]>nums2[ind]){
                    ans[i] = nums2[greater];
                    break;
                }
            }
        }
        return ans;
    }
}