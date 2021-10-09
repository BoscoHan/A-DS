class Solution {
    private Map<Integer, Integer> cacheMap;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        //put starTime, endTime, profit together, then sort on startTime
        
        int[][] jobs = new int[profit.length][3];
        
        for (int i = 0; i < startTime.length; i++) 
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        cacheMap = new HashMap();
        return dfs(0, jobs);
    }
    
        
    private int dfs(int cur, int[][] jobs) {
        if (cur == jobs.length) 
            return 0;
        
        if (cacheMap.containsKey(cur)) 
            return cacheMap.get(cur);
        
        
        int next = findNextJob(cur, jobs);
        
    //if we schedule jobs[curr], the problem becomes profit of jobs[curr] + max profit of scheduling jobs starting from next available job index.
        int profitByTakingCur = jobs[cur][2] + (next == -1 ? 0 : dfs(next, jobs));
        int profitByNotTakingCur = dfs(cur + 1, jobs);
        
        cacheMap.put(cur, Math.max(profitByTakingCur, profitByNotTakingCur));
        return cacheMap.get(cur);
    }
    
    private int findNextJob(int curr, int[][] jobs) {
        //if next job doesn't overlap with curr job's end
        
        for (int next = curr+1; next < jobs.length; next++) {
            if (jobs[next][0] >= jobs[curr][1])
                return next;
        }
        return -1;
    }
}

/*
1,3  2,4    3,5    3,6
50   10     40     70
*/