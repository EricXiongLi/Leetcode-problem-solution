class Solution {
    public int maxSubArray(int[] nums) {
        int prev = 0;
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prev >= 0) {
                prev += nums[i];
            } else {
                prev = nums[i];
            }
            res = Math.max(prev, res);
        }
        return res;
    }
}