class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i -1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int topLeftRow = Math.max(i - k, 0);
                int topLeftCol = Math.max(j - k, 0);
                int bottomRightRow = Math.min(i + k, m - 1);
                int bottomRightCol = Math.min(j + k, n - 1);
                res[i][j] = calculateSum(dp, topLeftRow, topLeftCol, bottomRightRow, bottomRightCol);
            }
        }
        return res;
    }
    
    int calculateSum(int[][] dp, int r1, int c1, int r2, int c2) {
        return dp[r2 + 1][c2 + 1]  - dp[r2 + 1][c1] - dp[r1][c2 + 1] + dp[r1][c1];
    }
}