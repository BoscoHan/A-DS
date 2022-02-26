class Solution {
    int prevColor = -1;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        prevColor = image[sr][sc];
        dfs(image, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int i, int j, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length)
            return;
        
        if (image[i][j] != prevColor || image[i][j] == newColor)
            return;
        
        image[i][j] = newColor;
        
        dfs(image, i+1, j, newColor);
        dfs(image, i-1, j, newColor);
        dfs(image, i, j+1, newColor);
        dfs(image, i, j-1, newColor);
    }
}
