class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        //dp[i][j][k]: the path ending at [i, j], with sum divisible by k
        //dp[i][j][k] = dp[i][j - 1][k - grid[i][j]] + dp[i - 1][j][k - grid[i][j]];
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[1][1][grid[i][j] % k] = 1;
                    continue;
                }
                for (int r = 0; r < k; r++) {
                    //(a + b) % k == ((a % k) + b) % k;
                    
                    dp[i + 1][j + 1][((grid[i][j] % k) + r) % k] += dp[i + 1][j][r];
                    dp[i + 1][j + 1][((grid[i][j] % k) + r) % k] += dp[i][j + 1][r];
                    dp[i + 1][j + 1][((grid[i][j] % k) + r) % k] %= Math.pow(10, 9) + 7;
                    
                }
            }
        }
        return dp[m][n][0];
    } 
}