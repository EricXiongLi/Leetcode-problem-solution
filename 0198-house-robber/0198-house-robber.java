class Solution {
    public int rob(int[] nums) {
        //dp[i][0]: the max amount of money within nums[0...i], without robbing nums[i]
        //dp[i][1]: the max  ...., with robbing nums[i]

        //dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1])
        //dp[i][1] = dp[i - 1][0] + nums[i]
        int n = nums.length;
        //dp[-1][0] = 0, dp[-1][1] = 0
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}