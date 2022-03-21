class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = nums[0];
        
        for (int posn = 0; posn <= maxJump; posn++) {
            maxJump = Math.max(maxJump, nums[posn] + posn);
            if (maxJump >= nums.length -1)
                return true;
        }
        
        return false;
    }
}