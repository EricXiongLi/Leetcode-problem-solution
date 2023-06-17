class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //sliding window
        int curSum = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        for (int r = l; r < nums.length; r++) {
            curSum += nums[r];
            while (curSum >= target) {
                if (res > r - l + 1) {
                    res = r - l + 1;
                }
                curSum -= nums[l];
                l++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}