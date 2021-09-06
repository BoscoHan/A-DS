class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];

        for (int start = 0; start < nums.length-2; start++) {
            if (start > 0 && nums[start] == nums[start-1])
                continue;
            
            int mid = start+1;
            int end = nums.length-1;
            
            while (mid < end) {
                int sum = nums[start] + nums[mid] + nums[end];  
                
                if (sum == target)
                    return sum;
                
                else if (sum > target) {
                    while (mid < end && nums[end] == nums[end-1]) 
                        end--;
                    
                    end--;
                } else if (sum < target) {
                    while (mid < end && nums[mid] == nums[mid+1]) 
                        mid++;
                    
                    mid++;
                }
                
                //update result if closer target found:
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
            }            
        }
        
        return result;
    }
}