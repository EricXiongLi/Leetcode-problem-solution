class Solution {
    public String longestPalindrome(String s) {
        //dp[i][j]: wether the s[i : j] is palindrome
        //dp[i][j] = s.charAt(i) != s.charAt(j) ? false : i + 1 >= j - 1 ? dp[i + 1][j - 1] : false;
        int left = 0, right = 0;
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        for (int i = 0; i < l; i++) {
            dp[i][i] = true;
        }
        for (int i = l - 1; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (i + 1 <= j - 1) {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            if (j - i + 1 > right - left + 1) {
                                left = i;
                                right = j;
                            }
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        if (j - i + 1 > right - left + 1) {
                                left = i;
                                right = j;
                            }
                        dp[i][j] = true;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
}