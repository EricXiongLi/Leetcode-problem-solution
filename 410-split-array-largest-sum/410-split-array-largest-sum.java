class Solution {
    public int splitArray(int[] nums, int m) {
        int left = Integer.MAX_VALUE, right = 0;
        for (int i : nums) {
            right += i;
            left = Math.min(left, i);
        }
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    
    public boolean canSplit(int[] nums, int m, int mid) {
        int curSum = 0, subarray = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) return false;
            curSum += nums[i];
            if (curSum > mid) {
                subarray++;
                curSum = nums[i];
            }
        }
        return subarray <= m;
    }
}