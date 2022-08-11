class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int size = 1;
        for (int i = 1; i < n; i++) {
            int insertPos = binarySearch(dp, size, nums[i]);
            dp[insertPos] = nums[i];
            if (insertPos == size) size++;
        }
        return size;
    }
    
    private int binarySearch(int[] nums, int size, int target) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
            
    }
}