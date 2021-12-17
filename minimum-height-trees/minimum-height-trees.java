class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList();    

        if (n == 1) {
            result.add(0);
            return result;
        }
        
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap();
        
        for (int[] pair : edges) {
            int a = pair[0], b = pair[1];

            map.putIfAbsent(a, new ArrayList());
            map.putIfAbsent(b, new ArrayList());
            map.get(a).add(b);
            map.get(b).add(a);

            inDegree[a]++;
            inDegree[b]++;
        }        
         
        // BFS, start visiting from all vertices with inDegree = 1
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 1)
                queue.offer(i);
        }
        
        // start with nodes having the least indegree (ie; indegree=1, i.e the leaf nodes) 
        // and go on removing them i.e decrementing the indegree of nodes that're connected to them, until we reach the middle nodes.
        // last existing vertices with inDegree == 1 are the result

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currList = new ArrayList();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                currList.add(curr);
                
                for (int neighbor : map.get(curr)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 1)
                        queue.offer(neighbor);
                }
            }
            result = currList;
        }
        
        return result;
    }
}