class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i + 1][j + 1]: the longest common subsequence between text1[0..i] and text2[0..j]
        //dp[i][j] = 
        //1. max(dp[i][j - 1], dp[i - 1][j]) if text1[i] != text2[j]
        //2. dp[i - 1][j - 1] + 1if text1[i] == text2[j] 

        int l1 = text1.length(), l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[l1][l2];
    }
}