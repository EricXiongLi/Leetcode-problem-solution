class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = -1;
        while (l < r) {
            if (nums[l] + nums[r] < k) {
                res = Math.max(res, nums[l] + nums[r]);
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}