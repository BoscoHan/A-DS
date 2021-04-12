class Solution {
    public int countArrangement(int n) {
        List<List<Integer>> list = new ArrayList();
        backTrack(n, new ArrayList(), list);
        return list.size();
    }
    
    private void backTrack(final int n, List<Integer> currList, List<List<Integer>> list) {
        if (currList.size() == n) {
            list.add(new ArrayList(currList));
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (currList.contains(i))
                continue;
            
            currList.add(i);
            
            //if just added is a beautiful arrangement:
            //size is divisible by curr number && curr number divisible by size
            if (currList.size() % i == 0 || i % currList.size() == 0)
                backTrack(n, currList, list);
            
            currList.remove(currList.size() - 1);
        }
    }
}