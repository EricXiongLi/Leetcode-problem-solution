class Solution {
    public int maxProfit(int maxK, int[] prices) {
        //dp[i][k][0] = max(dp[i - 1][k][0], dp[i][k][1] + prices[i])
        //dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])
        int n = prices.length;
        if (n < 2) return 0;
        int[][][] dp = new int[n][maxK + 1][2];
        for (int k = 1; k <= maxK; k++) {
            dp[0][k][0] = 0;
            dp[0][k][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= maxK; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }
}