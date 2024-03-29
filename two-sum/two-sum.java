class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                
                int posn = map.get(target - nums[i]);
                return new int[] {i, posn};
            }
            
            map.put(nums[i], i);   
        }
        
        return new int[] {};
    }
}