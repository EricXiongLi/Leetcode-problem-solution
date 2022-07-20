class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, product = 1, ans = 0;
        if (k <= 1) return 0;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}