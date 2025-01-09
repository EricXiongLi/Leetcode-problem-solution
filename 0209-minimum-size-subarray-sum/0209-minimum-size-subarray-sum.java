class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = Integer.MAX_VALUE;
        int curSum = 0;
        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target) {
                res = Math.min(res, right - left + 1);
                curSum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}