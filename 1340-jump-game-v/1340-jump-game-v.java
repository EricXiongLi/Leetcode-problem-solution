class Solution {
    Integer[] memo;
    public int maxJumps(int[] arr, int d) {
        //dp[i]: the max jump when starting from i th index
        //dp[i] = 1 + max(dp[j]): j is the reachable index when jumping from i
        memo = new Integer[arr.length];
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(arr, d, i));
        }
        return res;
    }
    
    private int dfs(int[] nums, int d, int pos) {
        if (memo[pos] != null) return memo[pos];
        int res = 1;
        for (int i = pos + 1; i <= Math.min(pos + d, nums.length - 1); i++) {
            if (nums[i] >= nums[pos]) break;
            res = Math.max(res, 1 + dfs(nums, d, i));
        }
        for (int i = pos - 1; i >= Math.max(0, pos - d); i--) {
            if (nums[i] >= nums[pos]) break;
            res = Math.max(res, 1 + dfs(nums, d, i));
        }
        memo[pos] = res;
        return memo[pos];
    }
}