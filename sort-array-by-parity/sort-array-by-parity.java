class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int evenIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[evenIndex];
                nums[evenIndex++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}