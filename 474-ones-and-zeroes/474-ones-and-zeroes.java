class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        //if (m >= cur0 && n >= cur1) 
        //dp[k][m][n] = max (dp[k - 1][m][n], dp[k - 1][m - cur0][n - cur1] + 1)
        //else
        //dp[k][m][n] = dp[k - 1][m][n]
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int zero = 0, one = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= zero && j >= one) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}