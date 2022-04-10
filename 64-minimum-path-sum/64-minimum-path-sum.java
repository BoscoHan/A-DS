class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                
                if (i == 0 && j == 0) 
                    dp[i][j] = grid[i][j];
                
                //if edge:
                else if (i == 0) 
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                
                else if (j == 0) 
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                
                else 
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                
            }
        }
        
        return dp[m-1][n-1];
    }
}