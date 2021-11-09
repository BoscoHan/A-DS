class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length <= 1)
            return 0;
            
        Arrays.sort(nums);
        int res = 0;
        int valToLook = nums[0] + 1;
        
        //[3,2,1,2,1,7]
        //[1,1,2,2,3,7]
        
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] > nums[i-1]) 
                valToLook = Math.max(valToLook, nums[i]);
            
            
            res += valToLook - nums[i];
            valToLook++;
        }
        
        return res;
    }
}