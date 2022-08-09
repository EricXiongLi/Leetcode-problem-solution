class Solution {
    public int maxProfit(int[] prices) {
        //dp[i][0] : balance in i th pos, without stock in account;
        //dp[i][1]: balance in i th pos, with stock in accountant;
        //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]) = -nums[i]
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}