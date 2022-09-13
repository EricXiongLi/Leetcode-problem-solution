class Solution {
    public int missingElement(int[] nums, int k) {
        //{4, 7, 9, 10}
        //{4, 5, 6, 7, 8, 9. 10, 11, }
        int l = 0, r = nums.length - 1;
        int totalMissing = nums[r] - nums[l] + 1 - (r - l + 1);
        if (totalMissing < k) {
            return nums[r] + k - totalMissing;
        }
        while (l < r - 1) {
            int mid = l + r >> 1;
            int shouldHave = nums[mid] - nums[l] + 1;
            int actualHave = mid - l + 1;
            int missing = shouldHave - actualHave;
            if (k <= missing) {
                r = mid;
            } else {
                l = mid;
                k = k - missing;
            }
        }
        return nums[l] + k;
    }
}