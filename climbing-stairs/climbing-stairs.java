class Solution {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        
        int prevA = 1;
        int prevB = 2;
        int steps = prevA + prevB;
        
        for (int i = 3; i <= n; i++) {
            steps = prevA + prevB;
            prevA = prevB;
            prevB = steps;
        }
        
        return steps;
    }
}
