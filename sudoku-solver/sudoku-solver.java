class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                
                if (board[i][j] == '.') {
                    
                    //try every num. 1 through 9
                     for(char c = '1'; c <= '9'; c++){
                        
                         if (isValid(board, i, j, c)) {
                             board[i][j] = c;
                         
                             // simulate taking curr board
                             if (solve(board))
                                 return true;
                         
                             //go back
                             else
                                board[i][j] = '.';
                             
                         }                     
                     }
                    
                    return false;
                }              
            }
        }
        
        return true;
    }
    
    
    private boolean isValid(char[][] board, int row, int col, char c) {
        int regionRow = 3 * (row / 3);  //region start row
        int regionCol = 3 * (col / 3);   //region start col
        
        for (int x = 0; x < 9; x++) {
            
            //check row:
            if (board[x][col] == c) return false;
            
            //check col:
            if (board[row][x] == c) return false;
            
            // check 3x3 box:
            if (board[regionRow + x / 3][regionCol + x % 3] == c) return false;
        }
        return true;
    }
}