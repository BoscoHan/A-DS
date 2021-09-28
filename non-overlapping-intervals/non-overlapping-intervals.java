class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2)
            return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        // System.out.println(Arrays.deepToString(intervals));
        
        int overLap = 1;
        int[] prevInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            
            if (currInterval[0] >= prevInterval[1]) {
                overLap++;
                prevInterval[1] = currInterval[1];
            }
        }
        
        return intervals.length - overLap;        
    }
}