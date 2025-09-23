class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //dp[i]: the longest continuous increasing subsequence ending with nums[i]
        //dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1: 1;
        int res = 1;
        int prev = 1, cur = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur = prev + 1;
            } else {
                cur = 1;
            }
            res = Math.max(cur, res);
            prev = cur;
        }

        return res;
    }
}