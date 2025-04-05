class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int n = nums.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            }
            if (nums[m] >= nums[0]) {
                if (target >= nums[0] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[n - 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}