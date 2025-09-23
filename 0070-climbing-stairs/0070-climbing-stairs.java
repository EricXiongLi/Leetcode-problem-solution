class Solution {
    public int climbStairs(int n) {
        //dp[i]: the # of ways to reach n
        //dp[n] = dp[n - 1] + dp[n - 2]
        //a         b           c
        //dp[1] = 1
        //dp[2] = 2;
        int a = 0, b = 2, c = 1;

        if (n <= 2) return n;
        for (int i = 3; i <= n; i++) {
            a = b + c;
            c = b;
            b = a;
        }

        return a;
    }
}