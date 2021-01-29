class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        while (sb.length() < b.length()) {
            count++;
            sb.append(a);
        }
        
        //ab cdabcdab cd
        if (sb.toString().contains(b)) 
            return count;
        
        //one last append:
        String temp = sb.append(a).toString();
        if (temp.contains(b))
            return count+1;
        
        return -1;
    }
}