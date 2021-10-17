class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // use arr to track the accumulated sum, but instead of the sum, store the sum%k.
        // if you find duplicated sum%k values, then that the subArr btw those two indexes will be the solution.
        
        // [4,1,2,3],  k = 6
        // if we get the accumulated sum arr,  [4, 5, 7, 10]
        // if we make it accumulated sum % k,  [4, 5, 1, 4]
        // notice that there is duplicated 4's. The diffference between these two sums in theory must be a multiple of 6 since we've only been storing the num % k.
        
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            if (k != 0) 
                runningSum %= k;
            
            
            if (map.containsKey(runningSum)) {
                //if posn between two arr elements
                if (i - map.get(runningSum) > 1)
                    return true;
            } else {
                map.put(runningSum, i);
            }
        }          
                
        return false;    
    }
}