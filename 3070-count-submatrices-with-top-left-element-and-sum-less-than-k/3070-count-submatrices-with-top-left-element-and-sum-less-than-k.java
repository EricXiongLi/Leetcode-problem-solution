class Solution {
    public int countSubmatrices(int[][] grid, int k) {
      int m = grid.length;
      int n = grid[0].length;
      int res = 0;
      for (int c = 0; c < n; c++) {
        grid[0][c] = (c == 0 ? 0 : grid[0][c - 1]) + grid[0][c];
        if (grid[0][c] <= k) res++;
      }

      for (int r = 1; r < m; r++) {
        grid[r][0] = grid[r - 1][0] + grid[r][0];
        if (grid[r][0] <= k) res++;
      }

      for (int r = 1; r < m; r++) {
        for (int c = 1; c < n; c++) {
            grid[r][c] = grid[r - 1][c] + grid[r][c - 1] - grid[r - 1][c - 1] + grid[r][c];
            if (grid[r][c] <= k) res++;
        }
      }

      return res;
    }

}