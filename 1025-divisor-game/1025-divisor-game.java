class Solution {
    public boolean divisorGame(int n) {
        //dp[i]: whether current user can win the number i;
        boolean[] dp = new boolean[n + 1];
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = !dp[i - j];
                    if (dp[i] == true) break;
                }
            }
        }
        return dp[n];
        
    }
}