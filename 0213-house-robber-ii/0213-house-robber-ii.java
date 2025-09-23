class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public int rob(int[] nums, int start, int end) {
        //dp[i][0]: the max amount within nums[0...i], without robbing nums[i]
        //dp[i][1]: ..., with robbing nums[i]

        //dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
        //dp[i][1] = dp[i - 1][0] + nums[i]
        int prev0 = 0, prev1 = nums[start];
        int next0 = 0, next1 = 0;
        for (int i = start + 1; i <= end; i++) {
            next0 = Math.max(prev0, prev1);
            next1 = prev0 + nums[i];

            prev0 = next0;
            prev1 = next1;
        }

        return Math.max(prev0, prev1);
    }
}