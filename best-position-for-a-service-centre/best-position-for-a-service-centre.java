class Solution {
    public static final int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
    public static final double error = 0.000000001;

    
    public double getMinDistSum(int[][] positions) {
        double x = 0.0;
	    double y = 0.0;
        double step = 50;

        double res = distSum(positions, x, y);

        
        while (step > error) {
            boolean found = false;

            for (int[] dir : dirs) {
                //next values: greedily replace result if smaller distSum, else explore with bigger step size:
                double nx = x + dir[0] * step;
                double ny = y + dir[1] * step;
                double nextPointDistance = distSum(positions, nx, ny);

                if (nextPointDistance < res) {
                    res = nextPointDistance;
                    x = nx;
                    y = ny;
                    found = true;
                }
            }
            
            //continuously decrease step size, either halfs or stays the same
            step /= found ? 1 : 2;
        }        
        
        return res;
    }
        
    private double distSum(int[][] positions, double x, double y) {
        double res = 0.0;
        
        for (int[] position : positions) {
            res += Math.sqrt((x - position[0]) * (x - position[0]) + (y - position[1]) * (y - position[1]));
        }
        return res;
    }
}