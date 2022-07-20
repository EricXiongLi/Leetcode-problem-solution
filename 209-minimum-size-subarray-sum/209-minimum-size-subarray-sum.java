class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            while (end < nums.length && sum < target) {
                sum += nums[end];
                end++;
            }
            int curAns;
            if (sum >= target) {
                curAns = end - start;
                ans = Math.min(curAns, ans);
                while (sum >= target) {
                    sum -= nums[start];
                    start++;
                }
                curAns = end - start + 1;
                ans = Math.min(curAns, ans);
            }
            
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}