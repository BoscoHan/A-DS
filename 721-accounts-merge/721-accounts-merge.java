class Solution {
    int[] parents;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parents = new int[accounts.size()];
        //initially, the parents of each element is itself
        for (int i = 0; i < accounts.size(); i++) 
            parents[i] = i;
        
        //maps email to index
        Map<String, Integer> ownersMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                
                if (ownersMap.containsKey(email)) {
                    int personId = ownersMap.get(email);
                    union(personId, i);
                } else {
                    ownersMap.put(email, i);
                }
            }
            
        }

        Map<Integer, TreeSet<String>> usersMap = new HashMap();
        for (int i = 0; i < accounts.size(); i++) {
            int parent = find(i);
            List<String> emailsOfUser = accounts.get(i);
            usersMap.putIfAbsent(parent, new TreeSet<String>());
            usersMap.get(parent).addAll(emailsOfUser.subList(1, emailsOfUser.size()));
        }

        List<List<String>> ans = new ArrayList<List<String>>();
        
        for (var x : usersMap.keySet()) {
            String name = accounts.get(x).get(0);
            List<String> emails = new ArrayList<>(usersMap.get(x));
            emails.add(0, name);
            ans.add(emails);
        }
        return ans;
    }
    
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA != rootB) 
            parents[rootB] = rootA;
    }
    
    private int find(int x) {
        if (parents[x] != x)
            return find(parents[x]);
        else 
            return x;
    }
}