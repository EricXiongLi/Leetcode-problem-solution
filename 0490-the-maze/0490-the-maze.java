class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start[0], start[1], destination, m, n, visited);
    }
    
    public boolean dfs(int[][] maze, int startX, int startY, int[] destination, int m, int n, boolean[][] visited) {
        if (visited[startX][startY]) {
            return false;
        }
        if (startX == destination[0] && startY == destination[1]) {
            return true;
        }
        visited[startX][startY] = true;
        for (int[] dir : dirs) {
            int x = startX,  y = startY;
            while (x + dir[0] >= 0 && x + dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n && maze[x + dir[0]][y + dir[1]] == 0) {
                x += dir[0];
                y += dir[1];
            }
            if (dfs(maze, x, y, destination, m, n, visited)) {
                return true;
            }
        }
            
        return false;
    }
}