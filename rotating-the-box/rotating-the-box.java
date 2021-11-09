class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        int m = box.length, n = box[0].length;
        char[][] Rbox = new char[n][m];
        
        
        //rotate box:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Rbox[j][i] = box[m-i-1][j];
            }
        }
        
        // System.out.println(Arrays.deepToString(Rbox));
        
        
        for (int j = 0; j < Rbox[0].length; j++) {
            for (int i = Rbox.length-1; i >=0; i--) {
                if (Rbox[i][j] == '#') {
                    int currRow = i;
                    
                    while (currRow+1 < Rbox.length && Rbox[currRow+1][j] == '.') 
                        currRow++;
                    
                    
                    if (currRow != i) {
                        //swap stone w empty space
                        Rbox[currRow][j] = '#';
                        Rbox[i][j] = '.';
                    }                    
                }
            }       
        }
        
        
        return Rbox;
    }
}