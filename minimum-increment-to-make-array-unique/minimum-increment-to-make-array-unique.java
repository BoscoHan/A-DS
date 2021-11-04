class Solution {
    public int minIncrementForUnique(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int moves = 0;
        
        // 3 2 1 2 1 7
        
        
        // 1 1 2 2 3 7 nums
        // 1 2 3 4 5 
        
        //moves 6
        Arrays.sort(nums);
        
//         int valToLookFor = nums[0] + 1;
        
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > nums[i-1]) {
//                 moves += 
                
//             }
            
//         }
        
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                moves++;
                nums[i]++;

            } else if (nums[i] < nums[i-1]) {
             
                moves +=  nums[i-1] - nums[i] + 1;
                nums[i]= nums[i-1] + 1;
            }            
        }
                
        return moves;
    }
}