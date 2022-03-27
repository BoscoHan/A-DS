class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // <strength, List of indexes>
        Map<Integer, List<Integer>> map = new TreeMap();
        
        for (int i = 0; i < mat.length; i++) {
            int strength = getStrength(mat[i]);
            map.putIfAbsent(strength, new ArrayList());
            map.get(strength).add(i);
        }
        
        int[] result = new int[k];
        
        int index = 0;
        for (var key : map.keySet()) {
            for (int num : map.get(key)) {
                if (index == k)
                    return result;
                
                result[index++] = num;
            }
        }
        
        return result;        
    }
    
    // binary search to count number of 1's
    private int getStrength(int[] row) {
        int l = 0, r = row.length;
        
        while (l < r) {
            int mid = l + (r-l) /2;
            
            if (row[mid] != 0) 
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
}
