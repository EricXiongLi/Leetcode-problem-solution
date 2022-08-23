class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1,  0}, {-1, 0}};
        int m = grid.length, n = grid[0].length;
        boolean[] visited = new boolean[m * n];
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curRow = i, curCol = j;
                int curPos = curRow * n + curCol;
                if (!visited[curPos] && grid[i][j] == 1) {
                    int curAns = 1;
                    q.offer(curPos);
                    visited[curPos] = true;
                    while (!q.isEmpty()) {
                        int sz = q.size();
                        for (int k = 0; k < sz; k++) {
                            int visiting = q.poll();
                            int visitingRow = visiting / n, visitingCol = visiting % n;
                            for (int dir[] : dirs) {
                                int newRow = visitingRow + dir[0];
                                int newCol = visitingCol + dir[1];
                                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow * n + newCol] && grid[newRow][newCol] == 1) {
                                    q.offer(newRow * n + newCol);
                                    visited[newRow * n + newCol] = true;
                                    curAns++;
                                }
                            }
                        }
                    }
                    res = Math.max(res, curAns);
                }
            }
        }
        return res;
    }
}