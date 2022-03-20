class Solution {
    public int numDistinct(String s, String t) {
        int[][] memo = new int[s.length()][t.length()];
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));

        //bagbag , ba
        return countSubSequence(s, t, s.length(), t.length(), memo);
    }
    
    private int countSubSequence(String s, String t, int s_idx, int t_idx, int[][] memo) {
        if(t_idx == 0) return 1;
        if(s_idx == 0) return 0;
        
        int ans = memo[s_idx-1][t_idx-1];
        if (ans != -1)
            return ans;
        
        //if current letter from back matches:
        if (s.charAt(s_idx-1) == t.charAt(t_idx-1)) {
            //next itr can be any 2 combos, go back 1 letter on both, or go back one letter on longer str
            ans = countSubSequence(s, t, s_idx-1, t_idx-1, memo) + countSubSequence(s, t, s_idx-1, t_idx, memo);
        } else {
            //keep checking the longer string to see if match is earlier in string
            ans = countSubSequence(s, t, s_idx-1, t_idx, memo);
        }
        
        return memo[s_idx-1][t_idx-1] = ans;
    }
}