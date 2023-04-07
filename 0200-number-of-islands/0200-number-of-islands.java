class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j, int m , int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(grid, newRow, newCol, m, n);
        }
    }
}