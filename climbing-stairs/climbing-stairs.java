class Solution {
    public int climbStairs(int n) {
        int[] count = new int[n + 1];
        return recurse(n, count);
    }
    
    public int recurse(int n, int[] count) {
        if(n == 0) 
            return 1;
        if(n < 0) 
            return 0;
        if(count[n] > 0)
            return count[n];
        
        count[n] = recurse(n -1, count) +  recurse(n - 2, count); 
        return count[n];
    }
}