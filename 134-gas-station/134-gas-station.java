class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0, index = 0, tank = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int consumed = gas[i] - cost[i];
            tank += consumed;
            
            if (tank < 0) {
                tank = 0;
                index = i+1;
            }
            
            totalFuel += consumed;
        }
        
        if (totalFuel >= 0) {
            //solution found:
            return index;
        }
        
        return -1;
    }
}