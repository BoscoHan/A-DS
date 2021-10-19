class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;

        int[] l_sum = new int[nums.length];
        int[] r_sum = new int[nums.length];
    
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                l_sum[i] = nums[i];
            else {
                l_sum[i] = l_sum[i-1] + nums[i];
            }
        }        
        
        for (int i = nums.length-1; i>=0; i--) {
            if (i == nums.length-1)
                r_sum[i] = nums[i];
            else {
                r_sum[i] = r_sum[i+1] + nums[i];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (l_sum[i] == r_sum[i])
                return i;
        }
        
        return -1;
    }
}

// [1,7, 3,  6,  5,  6]
// [1,  8,  11, 17, 22, 28]
// [28, 27, 20, 17, 11, 6]
