class Solution {
    public int countHousePlacements(int n) {
        //dp[i]: ways starting from i
        //dp[i] = dp[i + 2] + dp[i + 1];
        int MOD = (int)1e9 + 7;
        int[] dp = new int[n + 2];
        dp[n - 1] = 2;
        dp[n] = 1;
        dp[n + 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] % MOD + dp[i + 2] % MOD;
        }
        return (int) ((1L * dp[0] * dp[0]) % MOD);
    }
}

