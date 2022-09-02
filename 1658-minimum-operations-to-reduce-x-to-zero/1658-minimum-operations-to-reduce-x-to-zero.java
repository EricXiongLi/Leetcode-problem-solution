class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = Arrays.stream(nums).sum();
        int left = 0, right = 0;
        int subSum = 0;
        int target = totalSum - x;
        int res = Integer.MIN_VALUE;
        while (right <= nums.length - 1) {
            subSum += nums[right];
            while (subSum > target && left <= right) {
                subSum -= nums[left];
                left++;
            }
            if (subSum == target) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}