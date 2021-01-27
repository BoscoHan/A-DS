class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet(), cols = new HashSet();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for (var i : rows) 
            for (int j = 0; j < matrix[i].length; j++) 
                matrix[i][j] = 0;
        
        for (var j : cols) 
            for (int i = 0; i < matrix.length; i++) 
                matrix[i][j] = 0;
        
    }
}
