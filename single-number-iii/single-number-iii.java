class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int x : nums) 
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        
        List<Integer> list = new ArrayList();
        for (int n : nums) {
            if (map.get(n) == 1)
                list.add(n);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}