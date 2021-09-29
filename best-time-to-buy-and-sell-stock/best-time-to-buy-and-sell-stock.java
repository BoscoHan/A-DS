class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        
        //kadane's algo:
        int[] diff = new int[prices.length-1];
        for (int i = 1; i < prices.length; i++) {
            diff[i-1] = prices[i] - prices[i-1];
        }
        
        int maxSum = diff[0];
        int currSum = diff[0];
        
        //diff: -6, 4, -2, 3, -2
        for (int i = 1; i < diff.length; i++) {
            
            // add next element to our currSum or starting a new subArr?
            currSum = Math.max(diff[i], currSum + diff[i]);
            maxSum = Math.max(maxSum, currSum);
        }       
        
        return maxSum < 0 ? 0 : maxSum;
    }
}