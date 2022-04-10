class MyCalendarTwo {
    private TreeMap<Integer, Integer> treeMap;
    
    public MyCalendarTwo() {
        treeMap = new TreeMap();    
    }
    
    public boolean book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int activeMeetings = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            activeMeetings += entry.getValue();
            
            if (activeMeetings > 2) {
                treeMap.put(start, treeMap.get(start) - 1);
                treeMap.put(end, treeMap.get(end) + 1);
                
                return false;
            }
        }
        
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */