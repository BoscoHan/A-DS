class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, count = 0;
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i-2] - nums[i-1] == nums[i-1] - nums[i]) {
                count++;
            } else {
                count = 0;
            }
            ans += count;
        }
        
        return ans;
    }
}