class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //<word, visited>
        Map<String, Boolean> visited = new HashMap();
        for (String w : wordList) 
            visited.put(w, false);
        
        if (!visited.containsKey(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        visited.put(beginWord, true);
        int length = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                var currWord = queue.poll().toCharArray();
                
                for (int index = 0; index < currWord.length; index++) {
                    char currChar = currWord[index];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == currChar)
                            continue;
                        
                        currWord[index] = c;
                        String newWord = String.valueOf(currWord);
                        
                        if (newWord.equals(endWord))
                            return length+1;
                        
                        if (visited.containsKey(newWord) && !visited.get(newWord))
                            queue.offer(newWord);
                        
                        visited.put(newWord, true);
                    }
                    
                    //revert the changed char in currWord
                    currWord[index] = currChar;
                }
            }
            
            length++;
        }
        return 0;
    }
}