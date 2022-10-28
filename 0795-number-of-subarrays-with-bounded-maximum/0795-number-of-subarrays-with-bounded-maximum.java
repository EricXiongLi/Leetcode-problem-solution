class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return atMost(nums, right) - atMost(nums, left - 1);
    }
    
    int atMost(int[] nums, int k) {
        int prev = 0;
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > k) {
                prev = 0;
            } else {
                prev = prev + 1;
            }
            count += prev;
        }
        return count;
    }
}