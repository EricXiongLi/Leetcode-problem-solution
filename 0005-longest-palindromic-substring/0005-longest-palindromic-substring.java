class Solution {
    public String longestPalindrome(String s) {
        //dp[i][j]: is the s[i: j] palindrome

        //dp[i][j] = s[i] == s[j] ? dp[i + 1][j - 1] : false;

        int left = 0, right = 0;
        int n = s.length();

        boolean[][] dp = new boolean[n][n];


        for (int r = n - 1; r >= 0; r--) {
            for (int c = r; c < n; c++) {
                char c1 = s.charAt(r);
                char c2 = s.charAt(c);

                dp[r][c] = c1 == c2 ? (r + 1 < c - 1 ? dp[r + 1][c - 1] : true) : false;

                if (dp[r][c] == true && c - r + 1 > right - left + 1) {
                    right = c;
                    left = r;
                }
            }
        }

        return s.substring(left, right + 1);
    }
}