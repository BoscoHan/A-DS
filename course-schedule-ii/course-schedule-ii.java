class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) 
            inDegree[prereq[0]]++;
        
        //add all course that don't have preReqs
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        List<Integer> orderList = new ArrayList();
        
        while (!queue.isEmpty()) {
            int currCourse = queue.poll();
            orderList.add(currCourse);
            
            //check over all preReqs to see if any preReq has been covered
            for (int[] preReq : prerequisites) {
                
                //curr course is preReq of something else, decrease the other courses' inDegree
                if (currCourse == preReq[1]) {
                    inDegree[preReq[0]]--;
                
                    //add to queue if that course no longer blocked
                    if (inDegree[preReq[0]] == 0)
                        queue.offer(preReq[0]);
                }
            }
            
        }
        
        
        if (orderList.size() == numCourses)
            return orderList.stream().mapToInt(i -> i).toArray();
        
        return new int[]{};
    }
}