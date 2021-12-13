class Solution {
    public int coinChange(int[] coins, int amount) {
        return change(coins, amount, new int[amount]);
    }
    
    private int change(int[] coins, int amountLeft, int[] cache) {
        if (amountLeft < 0)
            return -1;
        
        if (amountLeft == 0) 
            return 0;
        
        if (cache[amountLeft-1] != 0)
            return cache[amountLeft-1];
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = change(coins, amountLeft - coin, cache);
            if (result >= 0 && result < min)
            min = result + 1;
        }
        
        cache[amountLeft-1] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[amountLeft-1];
    }
}