/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node copiedNode = new Node(node.val);
        Queue<Node> queue = new LinkedList();
        queue.offer(node);
        
        
        Map<Node, Node> map = new HashMap();
        map.put(node, copiedNode);
        
        
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            
            for (Node neighbor : currNode.neighbors) {
                if (!map.containsKey(neighbor)) {
                    
                    queue.offer(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                
                //update the list of neighbors of the copied version:
                Node copiedNeighbor = map.get(neighbor);
                map.get(currNode).neighbors.add(copiedNeighbor);                    
            }
        }
        return copiedNode;
    }
}