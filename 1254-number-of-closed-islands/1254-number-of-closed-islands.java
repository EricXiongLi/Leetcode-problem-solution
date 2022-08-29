class Solution {
    int count = 0;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dfs(grid, 0, i, m, n);
            }
            if (grid[m - 1][i] == 0) {
                dfs(grid, m - 1, i, m, n);
            }
        }
        
        for (int j = 0; j < m; j++) {
            if (grid[j][0] == 0) {
                dfs(grid, j, 0, m, n);
            }
            if (grid[j][n - 1] == 0) {
                dfs(grid, j, n - 1, m, n);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int row, int col, int m, int n) {
        grid[row][col] = 2;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                dfs(grid, newRow, newCol, m, n);
            }
        }
    }
}