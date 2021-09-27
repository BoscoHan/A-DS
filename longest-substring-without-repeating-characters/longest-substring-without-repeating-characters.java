class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int length = 0, repeats = 0;
        
        Map<Character, Integer> map = new HashMap();
        
        //put end character in one at a time
        while (end < s.length()) {
            char c = s.charAt(end++);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            //repeats breaks rule, so forward the front ptr until no more repeats in window
            if (map.get(c) > 1)
                repeats++;
            
            while (repeats > 0) {
                char frontC = s.charAt(start++);
                if (map.get(frontC) > 1)
                    repeats--;
                
                map.put(frontC, map.get(frontC) - 1);   
            }
            
            length = Math.max(length, end - start);            
        }
        
        return length;
    }
}