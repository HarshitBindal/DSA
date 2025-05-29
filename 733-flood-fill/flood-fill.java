class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color){
            return image;
        }
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    private void fill(int[][] image, int sr, int sc, int color, int curr){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length) return;
        if(curr != image[sr][sc]) return;
        image[sr][sc] = color;
        fill(image, sr-1, sc, color, curr);
        fill(image, sr, sc+1, color, curr);
        fill(image, sr+1, sc, color, curr);
        fill(image, sr, sc-1, color, curr);
    }
}