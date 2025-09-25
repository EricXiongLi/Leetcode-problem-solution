class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isPacific = new boolean[m][n], isAtlantic = new boolean[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            queue.offer(new int[]{row, 0});
            visited[row][0] = true;
            isPacific[row][0] = true;
        }

        for (int col = 1; col < n; col++) {
            queue.offer(new int[]{0, col});
            visited[0][col] = true;
            isPacific[0][col] = true;
        }

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int neiRow = cur[0] + dir[0], neiCol = cur[1] + dir[1];
                if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n && heights[neiRow][neiCol] >= heights[cur[0]][cur[1]] && !visited[neiRow][neiCol]) {
                    queue.offer(new int[]{neiRow, neiCol});
                    visited[neiRow][neiCol] = true;
                    isPacific[neiRow][neiCol] = true;
                }
            }
        }

        queue.clear();
        visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            queue.offer(new int[]{row, n - 1});
            visited[row][n - 1] = true;
            isAtlantic[row][n - 1] = true;
        }

        for (int col = 0; col < n - 1; col++) {
            queue.offer(new int[]{m - 1, col});
            visited[m - 1][col] = true;
            isAtlantic[m - 1][col] = true;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int neiRow = cur[0] + dir[0], neiCol = cur[1] + dir[1];

                if (neiRow >= 0 && neiRow < m && neiCol >= 0 && neiCol < n && heights[neiRow][neiCol] >= heights[cur[0]][cur[1]] && !visited[neiRow][neiCol]) {
                    queue.offer(new int[]{neiRow, neiCol});

                    visited[neiRow][neiCol] = true;
                    isAtlantic[neiRow][neiCol] = true;
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (isPacific[row][col] && isAtlantic[row][col]) {
                    List<Integer> cur = new ArrayList<>(Arrays.asList(row, col));
                    res.add(cur);
                }
            }
        }

        return res;
    }
}