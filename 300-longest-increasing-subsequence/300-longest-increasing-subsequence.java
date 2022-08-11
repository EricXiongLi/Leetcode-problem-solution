class Solution {
  Integer[] dp;
    public int lengthOfLIS(int[] nums) {
      //dp[i] : length of LIS when ending at i th;
      //dp[i] = max(1, dp[j]) : j < i and nums[j] < nums[i]
      dp = new Integer[nums.length];
      dp[0] = 1;
      int max = 1;
      for (int i = 0; i < nums.length; i++) {
        max = Math.max(dfs(nums, i), max);
      }
      return max;
    }

    private int dfs(int[] nums, int pos) {
      if (dp[pos] != null) {
        return dp[pos];
      }
      int max = 1;
      for (int i = pos - 1; i >= 0; i--) {
        if (nums[i] < nums[pos]) {
          max = Math.max(max, 1 + dfs(nums, i));
        }
      }
      dp[pos] = max;
      return dp[pos];
    }
}