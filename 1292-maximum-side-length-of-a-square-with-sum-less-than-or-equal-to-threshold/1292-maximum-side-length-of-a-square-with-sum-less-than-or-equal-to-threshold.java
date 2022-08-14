class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int left = 1, right = Math.min(m, n);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isValid = false;
            for (int i = 1; i + mid - 1 <= m && isValid == false; i++) {
                for (int j = 1; j + mid - 1 <= n; j++) {
                    if (rangeSum(sum, i, j, mid) <= threshold) {
                        isValid = true;
                        left = mid + 1;
                        break;
                    }
                }
            }
            if (!isValid) {
                right = mid - 1;
            }
        }
        return right;
    }
    
    private int rangeSum(int[][] dp, int i, int j, int mid) {
        return (dp[i + mid - 1][j + mid - 1] - dp[i - 1][j + mid - 1] - dp[i + mid - 1][j - 1] + dp[i - 1][j - 1]);
    }
}