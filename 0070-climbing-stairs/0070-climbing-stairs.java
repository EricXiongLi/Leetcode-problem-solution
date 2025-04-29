class Solution {
    public int climbStairs(int n) {
        //ddp[n] = dp[n -1] + dp[n - 2];
        int a = 1, b = 1;
        if (n == 0 || n == 1) return 1;
        int c = 2;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}