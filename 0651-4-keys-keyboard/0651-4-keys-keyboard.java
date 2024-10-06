class Solution {
    public int maxA(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 5) {
                dp[i] = i;
            } else {
                dp[i] = Math.max(dp[i - 3] * 2, Math.max(dp[i - 4] * 3, dp[i - 5] * 4));
                dp[i] = Math.max(dp[i], dp[i - 6] * 5);
            }
        }
        
        return dp[n];
    }
}

//tc: O(n)
//sc: O(n)