class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for (int posn = 1; posn < nums.length-1; posn++) {
            if (dp[posn-1] < posn)
                return false;
            
            dp[posn] = Math.max(dp[posn-1], posn + nums[posn]);
            
            if (dp[posn] >= nums.length-1)
                return true;
        }
        
        return dp[nums.length-2] >= nums.length-1;
    }
}