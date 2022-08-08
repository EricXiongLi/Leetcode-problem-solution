class Solution {
    public int maxSubArray(int[] nums) {
        //f(i) : sum of [0, i] elements;
        //f(i) = f(i - 1) > 0 ? f(i - 1) + nums[i] : nums[i]
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}