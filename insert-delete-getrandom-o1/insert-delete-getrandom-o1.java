class RandomizedSet {
    
    // map<value, Index in list>
    Map<Integer, Integer> map;
    Random rand = new Random();
    List<Integer> list;
    
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        
        map.put(val, list.size());
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        
        //swap last one with val
        int index = map.get(val);
        int lastElement = list.get(list.size() -1);
        
        map.put(lastElement, index);
        list.set(index, lastElement);
        
        //remove
        map.remove(val);
        list.remove(list.size()-1);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */