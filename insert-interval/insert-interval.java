class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // intervals already sorted on starting 
        List<int[]> list = new ArrayList();

        for (int[] currInterval : intervals) {
            // [1,2],[3,5],[6,7],[8,10],[12,16]
            
            //new : [4,8]
            
            // currIterval end less than newInterval start
            if (currInterval[1] < newInterval[0] ) {
                list.add(currInterval);
                
                
            //currInterval start greater than newInterval end
            } else if (newInterval[1] < currInterval[0]) {
                list.add(newInterval);
                newInterval = currInterval;
            
            } else {
                //merge:
                newInterval[0] = Math.min(newInterval[0], currInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currInterval[1]);            
            }            
        }
        
        list.add(newInterval);
        
        return list.toArray(new int[list.size()][2]);
    }
}