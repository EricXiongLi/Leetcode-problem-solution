class Solution {
    public int maxSubArray(int[] nums) {
        //dp[i]: max sum ending with nums[i]
        //dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];

        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(dp[i], res);
        }

        return res;
    }
}