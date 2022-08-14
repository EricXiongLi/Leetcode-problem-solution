class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = Arrays.stream(nums).sum();
        int left = 0, right = sum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean canSplit(int[] nums, int m, int mid) {
        int sum = 0, subarrayNum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > mid) return false;
            sum += nums[i];
            if (sum > mid) {
                subarrayNum++;
                sum = nums[i];
            }
        }
        return subarrayNum <= m;
    }
}