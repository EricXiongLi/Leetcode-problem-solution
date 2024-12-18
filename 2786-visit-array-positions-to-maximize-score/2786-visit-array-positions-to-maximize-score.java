class Solution {
    public long maxScore(int[] nums, int x) {
        //dp[i][0]: the max score within nums[0...i], with ending value even num
        //dp[i][1]:..., with odd number ending
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        if (nums[0] % 2 == 0) {
            dp[1][0] = nums[0];
            dp[1][1] = nums[0] - x;
        } else {
            dp[1][1] = nums[0];
            dp[1][0] = nums[0] - x;
        }
        long res = 0L;
        for (int i = 2; i <= n; i++) {
            if (nums[i - 1] % 2 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - x) + nums[i - 1];
                dp[i][1] = dp[i - 1][1];
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - x) + nums[i - 1];
                dp[i][0] = dp[i - 1][0];
            }
            res = Math.max(res, dp[i][0]);
            res = Math.max(res, dp[i][1]);
        }
        
        return res;
    }
}