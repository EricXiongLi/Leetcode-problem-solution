class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(curSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        
        curSum = nums[0];
        int minSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.min(curSum + nums[i], nums[i]);
            minSum = Math.min(minSum, curSum);
            
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}