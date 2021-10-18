class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int maxLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    maxLen = Math.min(maxLen, j-i+1);
                    break;
                }
            }
            
        }
        
        
                
        return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
    }
}