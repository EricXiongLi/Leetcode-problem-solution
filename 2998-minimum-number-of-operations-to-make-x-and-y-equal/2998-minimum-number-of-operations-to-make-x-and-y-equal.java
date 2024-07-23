class Solution {
    int[] dp = new int[10011];
    public int minimumOperationsToMakeEqual(int x, int y) {
        Arrays.fill(dp, -1);
        return dp(x, y);
    }
    
    public int dp(int x, int y) {
        if (dp[x] != -1) {
            return dp[x];
        }
        if (x <= y) {
            dp[x] = y - x;
            return dp[x];
        }
        dp[x] = x - y;
        dp[x] = Math.min(dp[x], 5 - x % 5 + 1 + dp(x / 5 + 1, y));
        dp[x] = Math.min(dp[x], x % 5 + 1 + dp(x / 5, y));
        dp[x] = Math.min(dp[x], 11 - x % 11 + 1 + dp(x / 11 + 1, y));
        dp[x] = Math.min(dp[x], x % 11 + 1 + dp(x / 11, y));
        return dp[x];
    }
}

