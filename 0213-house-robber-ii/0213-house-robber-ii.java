class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        int res1 = rob(nums, 0, n - 2);
        int res2 = rob(nums, 1, n - 1);

        return Math.max(res1, res2);
    }

    public int rob(int[] nums, int l, int r) {
        int[] dp = new int[r - l + 1];
        dp[0] = nums[l];
        if (dp.length == 1) return dp[0];
        dp[1] = Math.max(nums[l], nums[l + 1]);

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i + l], dp[i - 1]);
        }

        return dp[r - l];
    }
}