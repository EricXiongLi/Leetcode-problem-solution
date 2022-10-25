class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int rob1 = rob(nums, 0, n - 2);
        int rob2 = rob(nums, 1, n - 1);
        return Math.max(rob1, rob2);
    }
    
    int rob(int[] nums, int l, int r) {
        int n = nums.length;
        dp = new int[n + 2];
        for (int i = r; i >= l; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[l];
    }
}

