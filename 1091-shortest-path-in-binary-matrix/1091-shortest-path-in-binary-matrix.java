class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<int[]> q = new LinkedList<>();
        if (grid[0][0] != 0) return -1;
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
            int curRow = cur[0], curCol = cur[1];
            if (curRow == m - 1 && curCol == n - 1) {
                return step;
            }
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    if (!visited[newRow][newCol]) {
                        q.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
            }
            step++;
        }
        return -1;
    }
}