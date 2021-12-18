class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        for (String word: wordDict) 
            set.add(word);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
    
        for (int i = 0 ; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String currSubStr = s.substring(i, j);
                
                if (set.contains(currSubStr) && dp[i]) 
                    dp[j] = true;
                
            }
        }
        
        return dp[s.length()];
    }
}