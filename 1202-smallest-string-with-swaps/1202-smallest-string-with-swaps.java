class Solution {
    int[] parents;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s.length() == 0) return null;
        
        parents = new int[s.length()];
        
        //initially each element is its own group
        for (int i = 0; i < parents.length; i++) 
            parents[i] = i;
        
        //In each pair, create connected groups using union-find. the smaller index is the parent
        for (var pair : pairs) {
            union(pair.get(0), pair.get(1));
        }
        
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        char[] charArr = s.toCharArray();
        
        for (int i = 0; i < charArr.length; i++) {
            int root = find(i);
            map.putIfAbsent(root, new PriorityQueue());
            map.get(root).offer(charArr[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i++) 
            sb.append(map.get(find(i)).poll());
        
        return sb.toString();
    }
    
    private void union(int a, int b) {
        //set the root of one tree to be the child of another:
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB) 
            parents[rootB] = rootA;
        else 
            parents[rootA] = rootB;
    }
        
    private int find(int x) {
        //find root of the subtree, the parent of the root is itself.
        if (parents[x] != x) 
            return find(parents[x]);
        else 
            return x;
    }
}