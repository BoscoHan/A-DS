class Solution {
        
    public int carFleet(int target, int[] position, int[] speed) {
        // stack to keep track of times to reach dest
        Stack<Double> stack = new Stack();
                
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        
        // Sort the cars in DESC order based on their position, car closest to target goes 1st
        Arrays.sort(cars, (a, b) -> Integer.compare(b.posn, a.posn));
        
        for (Car currCar : cars) {
            
            var timeToDest = (double)(target - currCar.posn) / ((double)currCar.speed);
            
            System.out.println(timeToDest);
            
            // if prev timeToTarget is longer than the one about to be inserted, they form 1 fleet 
            if (stack.size() > 0 && stack.peek() >= timeToDest) {
                timeToDest = stack.pop();
            }
            
            stack.push(timeToDest);
        }
        
        return stack.size();
    }
    
}

class Car {
    int posn;
    int speed;
    
    public Car (int p, int s) {
        posn = p;
        speed = s;
    }
}