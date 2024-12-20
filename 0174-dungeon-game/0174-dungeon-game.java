class Solution {
    int[][] memo;
    public int calculateMinimumHP(int[][] grid) {
        //dfs(0, 0) = min(dfs(1, 0), dfs(0, 1)) - grid[0][0]
        int m = grid.length, n = grid[0].length;
        memo = new int[m][n];
        return dfs(grid, m, n, 0, 0);
    }
    
    public int dfs(int[][] grid, int m, int n, int i, int j) {
        if (memo[i][j] > 0) return memo[i][j];
        
        if (i == m - 1 && j == n - 1) {
            memo[i][j] = Math.max(1, 1 - grid[i][j]);
            return memo[i][j];
        }
        
        if (i == m - 1) {
            memo[i][j] = Math.max(dfs(grid, m, n, i, j + 1) - grid[i][j], 1);
            return memo[i][j];
        }
        
        if (j == n - 1) {
            memo[i][j] = Math.max(dfs(grid, m, n, i + 1, j) - grid[i][j], 1);
            return memo[i][j];
        }
        
        memo[i][j] = Math.max(Math.min(dfs(grid, m, n, i + 1, j), dfs(grid, m, n, i, j + 1)) - grid[i][j], 1);
        return memo[i][j];
    }
}