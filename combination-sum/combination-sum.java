class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList();
        
        backTrack(candidates, target, 0, list, new ArrayList());
        return list;
    }
    
    private void backTrack(int[] candidates, int target, int index, List<List<Integer>> list, List<Integer> currList) {
        if (target == 0)
            list.add(new ArrayList(currList));
        
        else if (target < 0)
            return;
        

        for (int i = index; i < candidates.length; i++) {
            currList.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, list, currList);
            currList.remove(currList.size() -1);
        }
    }
}