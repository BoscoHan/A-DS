class Solution {
    int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) 
            parents[i] = i;
        
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            
            //if both parents are the same for two subgraphs, then that edge is redundant
            if (find(from) == find(to)) {
                return edge;
            }
            
            union(from, to);
        }
        return new int[]{-1,-1};
    }
    
    private int find(int x) {
        if (x == parents[x])
            return x;
        
        return parents[x] = find(parents[x]);
    }
    
    private void union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);
        
        if (rootA != rootB)
            parents[rootA] = rootB;
    }
}