class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= target) {
                while (sum >= target) {
                    res = Math.min(res, i - left + 1);
                    sum -= nums[left];
                    left++;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}