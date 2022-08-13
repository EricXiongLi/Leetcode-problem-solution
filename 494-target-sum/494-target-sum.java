class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //dp[i][j]: the first i elements and sum is j
        //case1: nums[i] = 0: dp[i - 1][j]
        //else: dp[i - 1][j - sums[i]] + dp[i - ]
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) return 0;
        int newTarget = (target + sum) / 2;
        return subsequenceSum(nums, newTarget);
    }
    
    private int subsequenceSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = target; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j - nums[i]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }
}