class Solution {
    public boolean canPartition(int[] nums) {
        //dp[i][j]: the max sum when choosing between first i th  stones, with the available capacity of j
        //dp[i][j] = max(dp[i][j - weight(i)] + val(i), dp[i - 1][j]);
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        sum /= 2;
        int[][] dp = new int[nums.length][sum + 1];
        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - nums[i]] + nums[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }               
            }
        }
        return dp[nums.length - 1][sum] == sum;
    }
}