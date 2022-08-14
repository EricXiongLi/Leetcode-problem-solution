class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        
        boolean isValid = false;
        int ans = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = ans; i + k - 1 <= m && j + k - 1 <= n && k <= Math.min(m, n); k++) {
                    if (rangeSum(sum, i, j, k) <= threshold) {
                        ans = k + 1;
                        isValid = true;
                        j--;
                        break;
                    }
                }
            }
        }
        return ans - 1;
    }
    
    private int rangeSum(int[][] dp, int i, int j, int mid) {
        return (dp[i + mid - 1][j + mid - 1] - dp[i - 1][j + mid - 1] - dp[i + mid - 1][j - 1] + dp[i - 1][j - 1]);
    }
}