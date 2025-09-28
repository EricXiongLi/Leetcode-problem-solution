class Solution {
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList<>();//[row, col, kLeft]
        int m = grid.length, n = grid[0].length;
        if (m - 1 == 0 && n - 1 == 0) return 0;
        boolean[][][] visited = new boolean[m][n][k + 1];
        if (k >= m + n - 3) return m + n - 2;
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int level = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int neiRow = dir[0] + cur[0], neiCol = dir[1] + cur[1];
                    if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n) {
                        if (visited[neiRow][neiCol][cur[2]]) continue;
                        if (neiRow == m - 1 && neiCol == n - 1) {
                            System.out.println("nei row, nei col: " + neiRow + neiCol);
                            System.out.println("current k: " + cur[2]);
                            return level;
                        }
                        if (grid[neiRow][neiCol] == 1) {
                            if (cur[2] >= 1) {
                                queue.offer(new int[]{neiRow, neiCol, cur[2] - 1});
                                visited[neiRow][neiCol][cur[2] - 1] = true;
                            }
                        } else {
                            queue.offer(new int[]{neiRow, neiCol, cur[2]});
                            visited[neiRow][neiCol][cur[2]] = true;
                        }
                    }
                    
                }
            }
        }
        return -1;
    }
}