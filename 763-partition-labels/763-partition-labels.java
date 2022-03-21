class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList();
        int[] lastIndexes = new int[26];
        
        for (int i = 0; i < s.length(); i++) 
            lastIndexes[s.charAt(i) - 'a'] = i;
        
        
        int end = 0, starting = 0;
        for (int i = 0; i < s.length(); i++) {
            //gets current letter's ending location
            end = Math.max(end, lastIndexes[s.charAt(i) - 'a']);
            
            //end location found, start next itr
            if (i == end) {
                list.add(end - starting + 1);
                starting = end + 1;
            }
        }
        
        System.out.println(Arrays.toString(lastIndexes));
        
        return list;
    }
}