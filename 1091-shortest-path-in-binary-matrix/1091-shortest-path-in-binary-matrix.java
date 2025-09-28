class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int level = 0;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();

                for (int[] dir : dirs) {
                    int neiRow = cur[0] + dir[0], neiCol = cur[1] + dir[1];

                    if (neiRow == m - 1 && neiCol == n - 1) return level + 1;;
                    if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n && !visited[neiRow][neiCol] && grid[neiRow][neiCol] == 0) {
                        queue.offer(new int[] {neiRow, neiCol});
                        visited[neiRow][neiCol] = true;
                    }
                }
            }
        }

        return -1;
    }
}