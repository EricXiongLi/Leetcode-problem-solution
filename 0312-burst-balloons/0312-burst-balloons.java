class Solution {
    public int maxCoins(int[] nums) {
        //dp[i][j]: maxCoins between nums[i][j]
        //[0...i - 1, i, ...k...., j, ...]
        //dp[i][j] = max(dp[i][k - 1] + dp[k + 1][j] + nums[k] * nums[i - 1] * nums[j + 1])

        int n = nums.length;

        int[][] dp = new int[n][n];

        for (int r = n - 1; r >= 0; r--) {
            for (int c = r; c < n; c++) {
                if (c == r) {
                    dp[r][c] = nums[r] * (r - 1 >= 0 ? nums[r - 1] : 1) * (c + 1 < n ? nums[c + 1] : 1);
                } else {
                    for (int k = r; k <= c; k++) {
                        dp[r][c] = Math.max(dp[r][c], (r <= k - 1 ? dp[r][k - 1] : 0) + (k + 1 <= c ? dp[k + 1][c] : 0) + nums[k] * (r - 1 >= 0 ? nums[r - 1] : 1) * (c + 1 < n ? nums[c + 1] : 1));
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}