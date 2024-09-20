class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (r > l) {
            if (nums[l] + nums[r] >= k) {
                r--;
            } else {
                res = Math.max(res, nums[l] + nums[r]);
                l++;
            }
        }
        
        return res == Integer.MIN_VALUE ? -1 : res;
    }
}