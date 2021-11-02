class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length, n = box[0].length;
        char[][] Rbox = new char[n][m];
        
        //move stones to right most
        for (char[] row : box) {
            for (int j = n-1; j >=0; j--) {
                if (row[j] == '#') {
                    
                    int curCol = j;
                    
                    //while not at end and spot empty:
                    while (curCol + 1 < n && row[curCol+1] == '.') 
                        curCol++;
                    

                    //if shifted stones to the right
                    if (curCol != j) {
                        row[curCol] = '#';
                        row[j] = '.';
                    }
                }
            }
        }
        
        // System.out.println(Arrays.deepToString(box));
        
        //rotate:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Rbox[j][i] = box[m-i-1][j];
            }
        }
        
        return Rbox;
    }
}