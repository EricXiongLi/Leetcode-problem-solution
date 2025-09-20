class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int startRow = start[0], startCol = start[1];
        visited[startRow][startCol] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int[] dir : dirs) {
                int curRow = cur[0], curCol = cur[1];
                while (curRow + dir[0] < m && curRow + dir[0] >= 0 && curCol + dir[1] < n && curCol + dir[1] >= 0 && maze[curRow + dir[0]][curCol + dir[1]] == 0) {
                    curRow += dir[0];
                    curCol += dir[1];
                }


                if (curRow == destination[0] && curCol == destination[1]) {
                    return true;
                }

                if (!visited[curRow][curCol]) {
                    q.offer(new int[]{curRow, curCol});
                    visited[curRow][curCol] = true;
                }
            }
        }
        return false;
    }
}