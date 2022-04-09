class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) 
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        //bucket sort:
        // n + 1 buckets, the list in buckets[i] contains elements with the same frequency i
        var bucket = new List[nums.length + 1];
        
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList();
            }
            
            bucket[freq].add(key);    
        }
        
        int[] res = new int[k];
        int res_index = 0;
        for (int j = bucket.length-1; j >= 0; j--) {
            if (bucket[j] != null) {
                if (res_index >= k)
                    break;
                
                for (int i = 0; i < bucket[j].size(); i++) {
                    res[res_index++] = (int) bucket[j].get(i);
                }
            }
        }
        
        return res;
    }
}