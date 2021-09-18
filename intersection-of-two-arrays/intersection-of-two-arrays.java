class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        
        for (int x : nums1) 
            set.add(x);
        
        
        List<Integer> list = new ArrayList();
        for (int y : nums2) {
            if (set.contains(y)) {
                list.add(y);
                set.remove(y);
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}