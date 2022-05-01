class Solution {
    int[] parents;
    int[] components = new int[1];
    
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1)
            return -1;
        
        parents = new int[n];
        for (int i = 0; i < n; i++) 
            parents[i] = i;
        
        components[0] = n;
        for (int[] con : connections) {
            union(con[0], con[1], components);
        }
        
        return components[0] - 1;       
    }
    
    private void union(int A, int B, int[] components) {
        int rootA = find(A);
        int rootB = find(B);
        
        if (rootA != rootB) {
            parents[rootA] = rootB;
            components[0]--;
        }
    }
    
    private int find(int x) {
        if (parents[x] != x)
            return find(parents[x]);
        
        return x;
    }
}