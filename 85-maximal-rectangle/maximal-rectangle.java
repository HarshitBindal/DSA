class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1') heights[j]=heights[j]+1;
                else heights[j]=0;
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && heights[s.peek()]>heights[i]){
                int element = s.pop();
                int nse = i;
                int pse = s.isEmpty()? -1 : s.peek();
                maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
            }
            s.push(i);
        }
        while(!s.isEmpty()){
            int nse = n;
            int element = s.pop();
            int pse = s.isEmpty()? -1 : s.peek();
            maxArea = Math.max(maxArea, heights[element]*(nse-pse-1));
        }
        return maxArea;
    }
}