class Solution {
    int count = 1;
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    boolean[][] visited;
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        //[row, col]
        for (int i = 0; i < m; i++) {
            Arrays.fill(visited[i], false);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        int depth = 0;
        
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                int curRow = cur[0], curCol = cur[1];
                for (int[] dir : dirs) {
                    int newRow = curRow + dir[0];
                    int newCol = curCol + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >=0 && newCol < n && !visited[newRow][newCol]) {
                        if (grid[newRow][newCol] == 2) {
                            return depth;
                        } else {
                            q.offer(new int[]{newRow, newCol});
                            visited[newRow][newCol] = true;
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }
    
    private void dfs(int[][] grid, int row, int col, int m, int n) {
        visited[row][col] = true;
        grid[row][col] = count;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, m, n);
            }
        }
    }
}