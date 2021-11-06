class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        
        for (String str : strs) {
            char[] freqArr = new char[26];
            
            for (char c : str.toCharArray()) 
                freqArr[c - 'a']++;
            
            String keyStr = String.valueOf(freqArr);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList());
            
            map.get(keyStr).add(str);
        }
        
        List<List<String>> list = new ArrayList();
        for (String key : map.keySet()) 
            list.add(map.get(key));
        
        return list;
    }
}