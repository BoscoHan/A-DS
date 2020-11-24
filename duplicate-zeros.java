class Solution {
    public void duplicateZeros(int[] arr) {
        int[] res = new int[arr.length];
        
        int i = 0, j = 0;
        
        while (i < arr.length && j < res.length) {
            res[j++] = arr[i];
            
            if (j >= res.length)
                break;
            
            if (arr[i++] == 0) {               
                res[j++] = 0; 
            }            
        }
        
        for (int k = 0; k < arr.length; k++) {
            arr[k] = res[k];
        }
        
    }
}
