class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curSum = 0;
        int start = 0;
        int sum = Integer.MIN_VALUE;
        for (int end = 0; end < nums.length; end++) {
            curSum += nums[end];
            while (end - start + 1 > k) {
                curSum -= nums[start];
                start++;
            }
            if (end - start + 1 == k) {
                sum = Math.max(sum, curSum);
            }
        }
        
        return (double)sum / k;
    }
}