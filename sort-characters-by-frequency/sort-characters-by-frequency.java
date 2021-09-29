class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        
        PriorityQueue<Character> pq = new PriorityQueue((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            char currChar = pq.poll();
            int freq_currChar = map.get(currChar);
            
            for (int i = 0; i < freq_currChar; i++) {
                sb.append(currChar);
            }
        }
        
        return sb.toString();
    }
}