class Solution {
    public int maxProduct(int[] nums) {
        int product = 1;
        int max = Integer.MIN_VALUE;
        
        //scan from left:
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            max = Math.max(max, product);

            // System.out.println(product + "~" + max);

            if (nums[i] == 0)
                product = 1;
        }
        
        product = 1;
        //scan from right
        for (int i = nums.length-1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            
            // System.out.println(product + "~" + max);

            if (nums[i] == 0)
                product = 1;
        }
        
        return max;
    }
}