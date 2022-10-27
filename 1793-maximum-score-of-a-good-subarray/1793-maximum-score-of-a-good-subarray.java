class Solution {
    public int maximumScore(int[] nums, int k) {
        int min = nums[k];
        int l = k, r = k;
        int n = nums.length;
        int res = nums[k];
        while (l - 1 >= 0 || r + 1 < n) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else {
                if (nums[l - 1] > nums[r + 1]) {
                    l--;
                } else {
                    r++;
                }
            }
            min = Math.min(min, nums[r]);
            min = Math.min(min, nums[l]);
            res = Math.max(res, min * (r - l + 1));
        }
        return res;
    }
}