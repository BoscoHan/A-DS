class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int length = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }       
            length = Math.max(length, dp[i]);
        }
                
        return length;
    }
}