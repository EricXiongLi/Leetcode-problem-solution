class Solution {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]: longest common subsequence of text1[i, end] and text2[j, end2]
        //case1: text1
        memo = new Integer[text1.length()][text2.length()];
        return dp(text1, text2, 0, 0);
    }
    
    private int dp(String text1, String text2, int i1, int i2) {
        if (i1 == text1.length() || i2 == text2.length()) return 0;
        if (memo[i1][i2] != null) return memo[i1][i2];
        if (text1.charAt(i1) == text2.charAt(i2)) {
            memo[i1][i2] = dp(text1, text2, i1 + 1, i2 + 1) + 1;
        } else {
            memo[i1][i2] = Math.max(dp(text1, text2, i1, i2 + 1), dp(text1, text2, i1 + 1, i2));
        }
        return memo[i1][i2];
    }
}