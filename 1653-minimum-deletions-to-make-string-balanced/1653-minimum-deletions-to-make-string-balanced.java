class Solution {
    public int minimumDeletions(String s) {
        //i = "b": dp[i] = dp[i - 1]
        //i = "a" : dp[i] = Math.min(dp[i - 1] + 1, countB so far)
        int n = s.length();
        int dp = 0;
        int countB = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                dp = Math.min(countB, dp + 1);
            } else {
                dp = dp;
                countB++;
            }
        }
        
        return dp;
    }
}