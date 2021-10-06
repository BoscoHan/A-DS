class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arrL = new int[nums.length];
        int[] arrR = new int[nums.length];
        
        // [1,2,3,4]
        // [1, 1, 2, 6]
        arrL[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            arrL[i] = arrL[i-1] * nums[i-1];
        }
        
        // [1,2,3,4]
        // [24, 12, 4, 1]
        arrR[nums.length-1] = 1;
        
        for (int i = nums.length-2; i >= 0; i--) {
            arrR[i] = arrR[i+1] * nums[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = arrR[i] * arrL[i];
        }

        return nums;
    }
}