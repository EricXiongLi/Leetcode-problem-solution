class Solution {
    public int climbStairs(int n) {
        //dp[i]: number of ways to getr ith stair;
        //dp[i] = dp[i - 1] + dp[i - 2];
        if (n <= 2) {
            return n;
        }
        int prev1 = 1;
        int prev2 = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = prev1 + prev2;
            prev1 = prev2;
            prev2 = res;
        }
        return res;
    }
}