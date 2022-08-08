class Solution {
    public int maxProduct(int[] nums) {
        int min = 1, max = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 ) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
                res = Math.max(res, max);
            } else {
                int temp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(temp * nums[i], nums[i]);
                res = Math.max(res, max);
            }
        }
        return res;
    }
}