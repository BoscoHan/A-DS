class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // [# of ppl, from, to]   
        
        //sort based on pickup location
        Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));
        
        //sort pq on arrival location
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));
        
        for (int[] trip : trips) {
            
            //if passengers need to get off: prev trip's end before curr trip's start
            while (!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                capacity += pq.poll()[0];
            }
            
            capacity -= trip[0]; // less capacity as passengers get in.
            
            if (capacity < 0)
                return false;
            
            pq.offer(trip);
        }
        
        return true;
    }
}