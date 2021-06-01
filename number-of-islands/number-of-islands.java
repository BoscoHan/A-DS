class Solution {
    public int[][] dir = { {0,1}, {1,0}, {0,-1}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        
        int res = 0;
        
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[0].length; ++j) {
                
                if(grid[i][j] == '1') {
                    res ++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    public void bfs(char[][] grid, int r, int c) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r,c});
                
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            
            if (!isValidNode(grid, i, j))
                continue;
            
            grid[i][j] = '2';
            for(int k = 0; k < dir.length; k++)
                queue.add(new int[]{i+dir[k][0], j+dir[k][1]});
            
        }        
    }
    
    public boolean isValidNode(char[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        return (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1');
    }
}