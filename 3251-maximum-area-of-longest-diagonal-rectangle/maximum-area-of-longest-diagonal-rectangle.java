class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double maxi = 1;
        int area = 1;
        for(int rect[]: dimensions){
            double diag = Math.sqrt(rect[0]*rect[0] + rect[1]*rect[1]);
            if(diag>maxi) {
                maxi = diag;
                area = rect[0]*rect[1];
            }
            if(diag == maxi){
                area = Math.max(area, rect[0]*rect[1]);
            }
        }
        return area;
    }
}