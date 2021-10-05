class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;   
            }                
        }
        
        return count;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int curr) {
        for (int other = 0; other < isConnected.length; other++) {
            
            //We found an unvisited person in the current friend cycle 

            if (!visited[other] && isConnected[curr][other] == 1) {
                visited[other] = true;
                
                //Start DFS on this new found person
                dfs(isConnected, visited, other);
            }
        }
    }
}