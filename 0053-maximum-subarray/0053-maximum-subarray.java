class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            res = Math.max(curSum, res);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return res;
    }
}