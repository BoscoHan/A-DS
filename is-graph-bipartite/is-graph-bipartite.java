class Solution {
    public boolean isBipartite(int[][] graph) {
        Set<Integer> visited = new HashSet();
        int[] colors = new int[graph.length]; //assign two colors, 1 and 2 only

        for (int i = 0; i < graph.length; i++) {
            if (visited.contains(i))
                continue;
            
            Queue<Integer> queue = new LinkedList();
            queue.offer(i);
            visited.add(i);
            colors[i] = 1;
            
            while (!queue.isEmpty()) {
                int currNode = queue.poll();
                int currColor = colors[currNode];
                int neighborColor = (currColor == 1) ? 2 : 1;
                
                for (int connected_node : graph[currNode]) {
                    if (!visited.contains(connected_node)) {
                        queue.offer(connected_node);
                        visited.add(connected_node);
                        colors[connected_node] = neighborColor;
                    }
                    
                    else if (colors[connected_node] == currColor)
                        return false;
                }
            }  
        }
        return true;
    }
}