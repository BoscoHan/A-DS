class Solution {
    public int findMaxLength(int[] nums) {
        Map <Integer, Integer> map = new HashMap();
        
        //<balance, array posn>
        map.put(0, -1);
        int maxLen = 0, balance = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) 
                balance--;
            else 
                balance++;
            
            
            if (map.containsKey(balance)) {
                maxLen = Math.max(maxLen, i-map.get(balance));
                
            } else {
                map.put(balance, i);
            }           
        }
                
        return maxLen;
    }
}

