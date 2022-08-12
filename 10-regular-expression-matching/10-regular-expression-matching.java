class Solution {
    public boolean isMatch(String s, String p) {
        //dp[i][j]: whether s.substring(i, end) and p.substring(j, end) martchs;
        //
        int l1 = s.length();
        int l2 = p.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[l1][l2] = true;
        //
        for (int j = l2 - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') continue;
            if (j < l2 - 1 && p.charAt(j + 1) == '*') {
                dp[l1][j] = dp[l1][j + 2];
            } else {
                dp[l1][j] = false;
            }
        }
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                boolean firstMatch = s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
                if (j <= l2 - 2 && p.charAt(j + 1) == '*') {
                    boolean starMatchNull = dp[i][j + 2];
                    boolean starMatchStr = firstMatch && dp[i + 1][j];
                    dp[i][j] = starMatchNull || starMatchStr;
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
            
            
    }
}