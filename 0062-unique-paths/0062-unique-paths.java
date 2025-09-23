class Solution {
    public int uniquePaths(int m, int n) {
        //dp[i][j]: # of ways to reach [i, j]
        //dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int r = 0; r < m; r++) {
            dp[r][0] = 1;
        }
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                dp[r][c] += r - 1 >= 0 ? dp[r - 1][c] : 0;
                dp[r][c] += c - 1 >= 0 ? dp[r][c - 1] : 0;
            }
        }

        return dp[m - 1][n - 1];
    }
}