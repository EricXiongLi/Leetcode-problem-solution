class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        for (int row = 1; row <= l1; row++) {
            dp[row][0] = row;
        }
        for (int col = 1; col <= l2; col++) {
            dp[0][col] = col;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                                       
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j -1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[l1][l2];
    }
}