class Solution {
    public int[] sortByReflection(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        int i=0;
        for(int num: nums){
            String s = Integer.toBinaryString(num);
            String str = reverse(s);
            int x = Integer.parseInt(str, 2);
            arr[i][0]=x;
            arr[i][1]=num;
            i++;
        }
        Arrays.sort(arr, (a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        int[] res = new int[n];
        for(int j=0; j<n; j++){
            res[j]=arr[j][1];
        }
        return res;
    }
    private String reverse(String s){
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i=0, j=n-1;
        while(i<=j){
            char temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}