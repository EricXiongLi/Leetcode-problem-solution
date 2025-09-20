class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int greed = 0;
        for (int num : nums) {
            greed = greed >= 0 ? num + greed : num;
            res = Math.max(res, greed);
        }

        return res;
    }
}