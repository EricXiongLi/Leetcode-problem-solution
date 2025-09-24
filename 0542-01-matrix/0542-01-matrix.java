class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();

        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] == 0) {
                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
            }
        }

        int step = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int neiRow = cur[0] + dir[0], neiCol = cur[1] + dir[1];
                    if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n && mat[neiRow][neiCol] == 1 && !visited[neiRow][neiCol]) {
                        mat[neiRow][neiCol] = step;
                        visited[neiRow][neiCol] = true;
                        queue.offer(new int[]{neiRow, neiCol});
                    }
                }

            }
        }
        return mat;
    }
}