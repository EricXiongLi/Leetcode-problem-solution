class Solution {
    public int lastStoneWeightII(int[] stones) {
        //dp[i][j]: the maximum weight we can get among first i elements, with the capacity of j;
        //dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
        int sum = Arrays.stream(stones).sum();
        return sum - 2 * subsetSum(stones, sum / 2);
    }
    
    private int subsetSum(int[] nums, int capacity) {
        int n = nums.length;
        int[] dp = new int[capacity + 1];
        for (int i = 0; i< n; i++) {
            for (int j = capacity; j >= 1; j--) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
                }
            }
        }
        return dp[capacity];
    }
}