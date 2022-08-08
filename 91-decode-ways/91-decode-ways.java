class Solution {
    public int numDecodings(String s) {
        //if (s.substring(i - 1, i + 1) is valid) : dp(i) = dp (i - 1) + dp(i - 2)
        //else dp = dp(i - 1)
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            int left = Character.getNumericValue(s.charAt(i - 2));
            int right = Character.getNumericValue(s.charAt(i - 1));
            int value = left * 10 + right;
            if (value >= 10 && value <= 26) dp[i] += dp[i - 2];
            if (right != 0) dp[i] += dp[i - 1];
        }
        return dp[n];
    }
}