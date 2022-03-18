class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            
            ans = s1.length() > ans.length() ? s1 : ans;
            ans = s2.length() > ans.length() ? s2 : ans;
        }
        
        return ans;
    }
    
    public String palindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        return s.substring(i+1, j);
    }
}