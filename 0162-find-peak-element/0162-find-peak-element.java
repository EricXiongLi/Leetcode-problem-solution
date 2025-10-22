class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            boolean prev = mid - 1 < 0 ? true: nums[mid] > nums[mid - 1];
            boolean next = mid + 1 >= n ? true: nums[mid] > nums[mid + 1];

            if (prev && next) {
                return mid;
            }

            if (prev) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}