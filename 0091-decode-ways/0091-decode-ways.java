class Solution {
    public int numDecodings(String s) {
        //dp[i] : the ways of s[0, i)
        //if s.charAt(i - 1) != '0': dp[i] += dp[i - 1]
        //if s.substring(i - 2, i) is valid: dp[i] += dp[i - 2]
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;
        else dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if (isValid(s.substring(i - 2, i))) dp[i] += dp[i - 2];
        }
        return dp[n];
        
    }
    
    public boolean isValid(String s) {
        int val = Integer.valueOf(s);
        return val >= 1 && val <= 26 && s.charAt(0) != '0';
    }
}
