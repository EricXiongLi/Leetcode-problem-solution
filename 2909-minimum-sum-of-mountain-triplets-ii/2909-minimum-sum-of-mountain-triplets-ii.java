class Solution {
    public int minimumSum(int[] nums) {
        int n = nums.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

        int leftMin = nums[0];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            leftMin = Math.min(leftMin, nums[i - 1]);
            if (nums[i] > leftMin && nums[i] > rightMin[i + 1]) {
                res = Math.min(res, nums[i] + leftMin + rightMin[i + 1]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}