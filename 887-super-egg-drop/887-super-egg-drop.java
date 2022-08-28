class Solution {
    Integer[][] dp;
    public int superEggDrop(int k, int n) {
        //dp[k][n] = 1 + min(max(dp[k - 1][x - 1], dp[k][n - x]) | 1 <= x <= n)
        dp = new Integer[k + 1][n + 1];
        return helper(k, n);
    }
    
    private int helper(int k, int n) {
        if (dp[k][n] != null) return dp[k][n];
        if (k == 0) {
            dp[k][n] = 0;
            return 0;
        }
        if (k == 1) {
            dp[k][n] = n;
            return n;
        }
        if (n == 1 || n == 0) {
            dp[k][n] = n;
            return n;
        }
        int left = 1, right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (helper(k - 1, mid - 1) == helper(k, n - mid)) {
                break;
            } else if (helper(k - 1, mid - 1) < helper(k, n - mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        dp[k][n] = 1 + Math.max(helper(k - 1, mid - 1), helper(k, n - mid));
        return dp[k][n];
    }
}