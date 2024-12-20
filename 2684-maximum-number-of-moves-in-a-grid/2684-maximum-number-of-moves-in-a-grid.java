class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
      
        for (int c = n - 2; c >= 0; c--) {
            for (int r = 0; r < m; r++) {
                if (r - 1 >= 0 && grid[r - 1][c + 1] > grid[r][c]) dp[r][c] = Math.max(dp[r][c], dp[r - 1][c + 1] + 1);
                
                if (grid[r][c + 1] > grid[r][c]) dp[r][c] = Math.max(dp[r][c + 1] + 1, dp[r][c]);
                
                if (r + 1 <= m - 1 && grid[r + 1][c + 1] > grid[r][c]) dp[r][c] = Math.max(dp[r][c], dp[r + 1][c + 1] + 1);
                        
            }
        }
        
        for (int i = 0; i < m; i++) {
            res = Math.max(dp[i][0], res);
        }
        
        return res;
    }
}