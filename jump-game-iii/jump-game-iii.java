class Solution {
    public boolean canReach(int[] arr, int start) {
        return canReach(arr, start, new HashSet());
    }
    
    public boolean canReach(int[] arr, int idx, Set<Integer> set) {
        if (idx < 0 || idx >= arr.length || set.contains(idx))
            return false;
        
        if (arr[idx] == 0)
            return true;
        
        set.add(idx);
        return canReach(arr, idx + arr[idx], set) || canReach(arr, idx - arr[idx], set);
    }
}