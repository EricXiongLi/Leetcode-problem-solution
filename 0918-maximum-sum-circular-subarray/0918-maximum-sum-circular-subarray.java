class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int sum = Arrays.stream(nums).sum();
        int maxSum = nums[0];
        int curSum = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            curSum = curSum >= 0 ? nums[i] + curSum: nums[i];
            maxSum = Math.max(curSum, maxSum);
        }
        
        int minSum = nums[0];
        curSum = nums[0];
        for (int i = 1; i < n; i++) {
            curSum = curSum <= 0 ? nums[i] + curSum : nums[i];
            minSum = Math.min(minSum, curSum);
        }
        
        if (minSum == sum) {
            return maxSum;
        }
        return Math.max(maxSum, sum - minSum);
    }
}

//tc: O(n)
//sc: O(1)