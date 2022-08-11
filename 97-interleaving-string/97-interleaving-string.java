class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j]: whether the s1[0, i] and s2[0, j] can form s3[0, i + j];
        //dp[i][j] = (s1.charAt(i) == s3[i + j] && dp[i - 1][j]) || (s2.charAt(j) == s3.charAt(i + j) && dp[i][j - 1])
        int N1 = s1.length(), N2 = s2.length(), N3 = s3.length();
        if (N1 + N2 != N3) return false;
        boolean[][] dp = new boolean[N1 + 1][N2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= N2; i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= N1; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= N1; i++) {
            for (int j = 1; j <= N2; j++) {
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }
        return dp[N1][N2];
    }
}