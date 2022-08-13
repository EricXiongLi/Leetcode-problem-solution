class Solution {
    public boolean stoneGame(int[] piles) {
        //dp[i][j]: max relative score for current user, in piles[i, j];
        //dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i <= n - 1; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n - 1; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
        
    }
}