/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    int[][] direction = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtrack(robot, visited, 0, 0, 0);
        return;
    }
    
    private void backtrack(Robot robot, Set<String> visited, int x, int y, int arrow){
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newX = x + direction[arrow][0];
            int newY = y + direction[arrow][1];
            String path = newX + "-" + newY;

            if(!visited.contains(path) && robot.move()){
                visited.add(path);
                backtrack(robot, visited, newX, newY, arrow);
            }

            robot.turnRight();  //always turn right;
            arrow = (arrow + 1) % 4;
        }
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}