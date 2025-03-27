class Solution {
    private static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    bfs(grid, m, n, r, c);
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int m, int n, int r, int c) {
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r, c});
        grid[r][c] = '2';
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int neiR = dir[0] + cur[0];
                int neiC = dir[1] + cur[1];

                if (neiR >= 0 && neiR < m && neiC >= 0 && neiC < n && grid[neiR][neiC] == '1') {
                    grid[neiR][neiC] = '2';
                    q.offer(new int[]{neiR, neiC});
                }
            }
        }
    }
}