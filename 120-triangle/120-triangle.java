class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        
        //dp to store the cost up to this point:
        int[][] dp = new int[height][height];
        dp[0][0] = triangle.get(0).get(0);
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                //left edge
                if (j == 0)
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                
                //right edge
                else if (i == j) 
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                
                else 
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j < height; j++) {
            minCost = Math.min(minCost, dp[height-1][j]);
        }
        return minCost;
    }
}