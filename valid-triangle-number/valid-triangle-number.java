class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        
        // i             j  k
        // 3 19 22 24 35 82 84
        
        //start k from last index:
        for (int k = nums.length-1; k > 1; k--) {
            int i = 0, j = k-1;
            
            while (i < j) {
                
                if (nums[i] + nums[j] > nums[k]) {
                    ans += j-i;
                    j--;

                } 
                else 
                    //move i up to increase sum
                    i++;
            
            }
        }
        
        return ans;
    }
}