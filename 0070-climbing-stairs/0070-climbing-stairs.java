class Solution {
    public int climbStairs(int n) {
        //dp[i]: the ways to get n th stair
        //dp[i] = dp[i - 1] + dp[i - 2]
        if (n == 1) return 1;
        int[] dp = new int[n];
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}