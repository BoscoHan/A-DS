class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1); //edge case

        int runningSum = 0;
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum = (runningSum + nums[i]) % k;
            
            // -1 mod 5 should equal 4, not -1
            if (runningSum < 0) 
                runningSum += k;

            // System.out.println(runningSum);
            // System.out.println(map.getOrDefault(runningSum, 0) + "\n");

            
            result += map.getOrDefault(runningSum, 0);
            map.put(runningSum, map.getOrDefault(runningSum, 0) + 1);                        
        }
        
        return result;
    }
}