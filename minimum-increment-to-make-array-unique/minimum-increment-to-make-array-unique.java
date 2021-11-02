class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        
        int moves = 0;                
        int nextValLookFor = nums[0] + 1;
            
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] > nums[i-1]) {
                nextValLookFor = Math.max(nextValLookFor, nums[i]);
            }
            
            moves += nextValLookFor - nums[i];
            nextValLookFor++;
        }
        
        
        return moves;
    }
}