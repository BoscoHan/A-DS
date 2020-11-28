class Solution {
    Map<String, Boolean> map = new HashMap();
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) 
            total += x;
        
        if (total % 2 != 0)
            return false;
        
        return checkPartition(nums, 0, 0,total);
    }
    
    private boolean checkPartition(int[] nums, int index, int sum, int total) {
        String key = index + "|" + sum;
        if (map.containsKey(key))
            return map.get(key);
        
        //base case 1: subset's sum is exactly half of total:
        if (sum * 2 == total)
            return true;
        
        //base case 2: sum exceeds or got to end
        if (sum > total/2 || index >= nums.length)
            return false;
        
        //simulate taking or not taking curr number in the subset:
        boolean result = checkPartition(nums, index+1, sum + nums[index], total) || 
            checkPartition(nums, index+1, sum, total);
        
        map.put(key, result);
        return result;
    }    
}
