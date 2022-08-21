class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();// row, col, kLeft
        int m = grid.length, n = grid[0].length;
        if (k >= m + n - 3) return m + n - 2;
        k = Math.min(m + n - 3, k);
        boolean[][][] visited = new boolean[m][n][k + 1];
        q.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
            int curRow = cur[0], curCol = cur[1], kLeft = cur[2];
            if (curRow == m - 1 && curCol == n - 1) return step;
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (visited[newRow][newCol][kLeft]) continue;
                    if (grid[newRow][newCol] == 0) {
                        q.offer(new int[]{newRow, newCol, kLeft});
                        visited[newRow][newCol][kLeft] = true;
                    } else {
                        if (kLeft >= 1) {
                            q.offer(new int[]{newRow, newCol, kLeft - 1});
                            visited[newRow][newCol][kLeft - 1] = true;
                        }
                    }
                }
            }
            }
            step++;
        }
        return -1;
    }
}