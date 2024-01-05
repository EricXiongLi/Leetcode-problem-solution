class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int startX = start[0], startY = start[1];
        visited[startX][startY] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        return bfs(maze, start, destination, q, m, n, visited);
    }
    
    public boolean bfs(int[][] maze, int[] start, int[] destination, Queue<int[]> q, int m, int n, boolean[][] visited) {
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0], curY = cur[1];
            if (curX == destination[0] && curY == destination[1]) {
                    return true;
            }
            for (int[] dir : dirs) {
                int x = cur[0], y = cur[1];
                while(x + dir[0] >= 0 && x + dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n && maze[x + dir[0]][y + dir[1]] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                
                
                if (!visited[x][y]) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}