class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        
        for (int[] arr : trust) {
            inDegree[arr[1]]++;
            outDegree[arr[0]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            //person trusted by everyone but trusts nobody
            //inDegree indicates how many others trust curr person
            //outDegree indicates how many ppl curr person trusts
            if (inDegree[i] == n-1 && outDegree[i] == 0)
                return i;
        }
        
        return -1;
    }
}