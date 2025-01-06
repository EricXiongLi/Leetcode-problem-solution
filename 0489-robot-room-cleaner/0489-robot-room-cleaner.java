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
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<Pair<Integer, Integer>>();
    public void cleanRoom(Robot robot) {
        robot.clean();
        clean(robot, 0, 0, 0);
    }

    public void clean(Robot robot, int r, int c, int dir) {
        visited.add(new Pair(r, c));
        int newR = r + dirs[dir][0];
        int newC = c + dirs[dir][1];
        if (!visited.contains(new Pair(newR, newC)) && robot.move()) {
            robot.clean();
            clean(robot, newR, newC, dir);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();
        newR = r + dirs[(dir + 1) % 4][0];
        newC = c + dirs[(dir + 1) % 4][1];
        if (!visited.contains(new Pair(newR, newC)) && robot.move()) {
            robot.clean();
            clean(robot, newR, newC, (dir + 1) % 4);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }

        robot.turnRight();
        newR = r + dirs[(dir + 2) % 4][0];
        newC = c + dirs[(dir + 2) % 4][1];
        if (!visited.contains(new Pair(newR, newC)) && robot.move()) {
            robot.clean();
            clean(robot, newR, newC, (dir + 2) % 4);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }

        robot.turnRight();
        newR = r + dirs[(dir + 3) % 4][0];
        newC = c + dirs[(dir + 3) % 4][1];
        if (!visited.contains(new Pair(newR, newC)) && robot.move()) {
            robot.clean();
            clean(robot, newR, newC, (dir + 3) % 4);
            robot.turnRight();
            robot.turnRight();
            robot.move();
            robot.turnRight();
            robot.turnRight();
        }
        robot.turnRight();
    }
}