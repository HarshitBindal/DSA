class Solution {
    public double eps = 1e-6;
    public boolean judgePoint24(int[] cards) {
        double[] list = new double[4];
        for(int i=0; i<list.length; i++){
            list[i] = cards[i];
        }
        Arrays.sort(list);
        while(nextPermutation(list)){
            if(dfs(list)) return true;
        }
        return false;
    }
    private boolean dfs(double[] list){
        double a = list[0], b = list[1], c = list[2], d = list[3];
        if(dfs(a+b,c,d) || dfs(a-b,c,d) || dfs(a*b,c,d) || dfs(a/b,c,d)) return true;
        if(dfs(a,b+c,d) || dfs(a,b-c,d) || dfs(a,b*c,d) || dfs(a,b/c,d)) return true;
        if(dfs(a,b,c+d) || dfs(a,b,c-d) || dfs(a,b,c*d) || dfs(a,b,c/d)) return true;
        return false;
    }
    private boolean dfs(double a,  double b, double c){
        if(dfs(a+b,c) || dfs(a-b,c) || dfs(a*b,c) || dfs(a/b,c)) return true;
        if(dfs(a,b+c) || dfs(a,b-c) || dfs(a,b*c) || dfs(a,b/c)) return true;
        return false;
    }
    private boolean dfs(double a, double b){
        if(Math.abs(a+b-24)<=eps || Math.abs(a-b-24)<=eps || Math.abs(a*b-24)<=eps ||
        Math.abs(a/b-24)<=eps) return true;
        return false;
    }
    public boolean nextPermutation(double[] nums) {
        if(nums.length==1){
            return true;
        }
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i<0) return false;
        if(i>=0){
            int j = n-1;
            while(j>i && nums[i]>=nums[j]){
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
        return true;
    }
    private void reverse(double[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private void swap(double nums[], int i, int j){
        if(i!=j){
            double temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}