class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) 
            for (int j = 0; j < grid[i].length; j++) 
                maxArea = Math.max(maxArea, dfs(grid, i, j));
        
        return maxArea;
    }
    
    public int dfs(int[][] grid, int i, int j) {
        
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        
        if (grid[i][j] != 1)
            return 0;
        
        grid[i][j] = 0;
        
        
        return 1 + 
            dfs(grid, i+1, j) +
            dfs(grid, i-1, j) +
            dfs(grid, i, j+1) + 
            dfs(grid, i, j-1);
    }
}