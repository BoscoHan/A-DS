class Solution {
    public boolean isRobotBounded(String instructions) {
        String dir = "N";
        int x = 0, y = 0;
        
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                switch (dir) {
                    case ("N"): y++; break;
                    case ("S"): y--; break;
                    case ("W"): x--; break;
                    case ("E"): x++; break;
                }
            } else if (c == 'L') {
                switch(dir) {
                    case ("N"): dir = "W"; break;
                    case ("S"): dir = "E"; break;
                    case ("W"): dir = "S"; break;
                    case ("E"): dir = "N"; break;
                }
            } else if (c == 'R') {
                switch(dir) {
                    case ("N"): dir = "E"; break;
                    case ("S"): dir = "W"; break;
                    case ("W"): dir = "N"; break;
                    case ("E"): dir = "S"; break;
                }
            }
        }
        
        return x == 0 && y == 0 || dir != "N";
    }
}