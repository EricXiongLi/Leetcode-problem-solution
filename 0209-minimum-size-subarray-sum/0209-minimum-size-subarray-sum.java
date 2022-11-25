class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int curSum = 0;
        int l = 0;
        int res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            while (curSum >= target) {
                res = Math.min(r - l + 1, res);
                curSum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}