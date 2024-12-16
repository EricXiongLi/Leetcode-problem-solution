class Solution {
    public boolean checkPartitioning(String s) {
        //Inspired by WisdomPeak, I din't know intervals dp before
        int n = s.length();
        //is string[i, j] is palindrome
        //dp[i][j] = flase ? dp[i + 1][j - 1]
        boolean[][] dp = new boolean[n][n];
        for (boolean[] arr : dp) {
            Arrays.fill(arr, true);
        }
        for (int r = n - 1; r >= 0; r--) {
            for (int c = r; c <= n - 1; c++) {
                if (r == c) {
                    dp[r][c] = true;
                } else {
                    dp[r][c] = s.charAt(r) != s.charAt(c) ? false : dp[r + 1][c - 1];
                }
            }
        }
        
        //dp[i][j] = dp[i][m] + dp[m][k] + dp[k][j]
        for (int len1 = 1; 0 + len1 - 1 <= n - 3; len1++) {
            for (int len2 = 1; 0 + len1 - 1 + 1 + len2 - 1 <= n - 2; len2++) {
                if (dp[0][0 + len1 - 1] && dp[len1][len1 + len2 - 1] && dp[len1 + len2][n - 1]) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
}

//tc: O(n ^ 2)
//sc: O(n ^ 2)