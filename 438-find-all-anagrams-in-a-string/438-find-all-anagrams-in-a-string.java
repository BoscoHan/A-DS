class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList();
        
        Map<Character, Integer> map = new HashMap();
        for (char c : p.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0)+1);            
        
        
        int i = 0, j = 0;
        int count = map.size();
        
        while (j < s.length()) {
            char c = s.charAt(j);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    count--;
            }
            j++;

            while (count == 0) {
                char fC = s.charAt(i);
                
                if (map.containsKey(fC)) {
                    map.put(fC, map.get(fC)+1);
                    if (map.get(fC) > 0)
                        count++;
                }

                if (j - i == p.length())
                    list.add(i);
                i++;
            }
        }
        
        return list;
    }
}