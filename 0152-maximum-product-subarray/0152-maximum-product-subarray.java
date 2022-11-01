class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);
            } else {
                int temp = max;
                max = Math.max(nums[i], nums[i] * min);
                min = Math.min(nums[i], nums[i] * temp);
            }
            res = Math.max(res, Math.max(min, max));
        }
        return res;
    }
}