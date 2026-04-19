class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i=0, j=0;
        int maxi = Integer.MIN_VALUE;
        while(i<n && j<m){
            if(i<=j){
                if(nums1[i]<=nums2[j]){
                    maxi = Math.max(maxi, j-i);
                    j++;
                }
                else i++;
            }
            else j++;
        }
        return maxi==Integer.MIN_VALUE? 0: maxi;
    }
}