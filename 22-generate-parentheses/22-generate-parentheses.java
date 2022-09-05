class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backTrack(result, "", n, 0, 0);
        return result;
    }
    
    private void backTrack(List<String> result, String currStr, int n, int numOfOpenBrackets, int numOfCloseBrackets) {
        if (currStr.length() == 2 * n) {
            result.add(currStr);
            return;
        }
        
        if (numOfOpenBrackets < n) 
            backTrack(result, currStr + "(", n, numOfOpenBrackets+1, numOfCloseBrackets);
        
        if (numOfOpenBrackets > numOfCloseBrackets)
            backTrack(result, currStr + ")", n, numOfOpenBrackets, numOfCloseBrackets+1);
    }
}