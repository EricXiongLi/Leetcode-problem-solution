class Solution {
    int[][] lcsDP;
    public int deleteString(String s) {
        //for all possible i
        //dp[j] = 1 + max(dp[j + i1], dp[j + i2]);
        //dp[n] = 1
        int n = s.length();
        lcs(s, s);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (lcsDP[i][j] >= j - i) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }
        return dp[0];
    }
    
    void lcs(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        lcsDP = new int[n1 + 1][n2 + 1];
        
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    lcsDP[i][j] = 1 + lcsDP[i + 1][j + 1];
                } else {
                    lcsDP[i][j] = 0;
                }
            }
        }
    }
}