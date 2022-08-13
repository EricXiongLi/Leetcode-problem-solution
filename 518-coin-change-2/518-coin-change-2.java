class Solution {
    public int change(int amount, int[] coins) {
        //dp[i][j]: ways in the first i coins, with amount j
        //if coins[i] > j: dp[i][j] = dp[i - 1][j]
        //else dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]]
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[amount];
    }
}