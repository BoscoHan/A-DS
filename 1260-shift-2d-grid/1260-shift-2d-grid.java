class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList();
        int m = grid.length, n = grid[0].length;
        int tot = m*n;

        List<Integer> line = new ArrayList();
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                line.add(grid[i][j]);
            
        Collections.rotate(line, k);
        
        for (int i = 0; i < m; i++) 
            list.add(new ArrayList());
        
        int idx = 0, row = 0;
        while (idx < tot) {
            if (list.get(row).size() >= n)
                row++;
            
            list.get(row).add(line.get(idx));
            idx++;
        }
    
        return list;
    }
}