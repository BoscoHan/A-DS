class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        
        for (int a : asteroids) {
            if (a > 0)
                stack.push(a);
            else {
                
                while(!stack.isEmpty() && stack.peek() < Math.abs(a) && stack.peek() > 0) {
                    stack.pop();
                }
                
                
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
                
                
                if (!stack.isEmpty() && stack.peek() == Math.abs(a))
                    stack.pop();
                

            }
        }
        
        
        int[] remaining = new int[stack.size()];
        int i = stack.size()-1;
        while (!stack.isEmpty()) {
            remaining[i--] = stack.pop();
        }
        
        return remaining;
    }
}