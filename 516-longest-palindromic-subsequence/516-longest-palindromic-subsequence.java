class Solution {
    public int longestPalindromeSubseq(String s) {
        //dp[i][j]: longest  palindrome among s[i : j]
        //if (s.charAt(i) = s.charAt(j)) -> dp[i + 1][j - 1]
        //else -> max(dp[i + 1][j], dp[i][j - 1])
        int l = s.length();
        int[][] dp = new int[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = 1;
        }
        for (int i = l - 2; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][l - 1];
    }
}