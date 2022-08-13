class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[i][j]: the coinChange of coins of first i types, for amout j;
        //if j >= coins[i - 1]
                //if dp[i - 1][j] != -1  -> min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1)
                //else -> dp[i][j - coins[i - 1]] + 1
        //else -> dp[i - 1][j]
        
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = -1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                //we can take the cur coin
                if (j >= coins[i - 1]) {
                    //we can take the current coin
                    if (dp[i - 1][j] != -1) dp[i][j] = dp[i][j - coins[i - 1]] == -1 ? dp[i - 1][j] : Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                    // we have to take the cur coin
                    else dp[i][j] = dp[i][j - coins[i - 1]] == -1 ? -1 : dp[i][j - coins[i - 1]] + 1;
                } 
                //we can not take cur coin
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}