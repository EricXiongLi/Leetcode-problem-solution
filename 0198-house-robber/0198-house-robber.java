class Solution {
    public int rob(int[] nums) {
        //dp[i]: starting robbing from ith house
        //dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i + 2] + nums[i]);
        }
        return dp[0];
    }
}