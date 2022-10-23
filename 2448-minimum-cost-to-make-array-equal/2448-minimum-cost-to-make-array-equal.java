class Solution {
    public long minCost(int[] nums, int[] cost) {
        long left = 0, right = (long)1e7, res =Long.MAX_VALUE;
        while (left <= right) {
            long oneThird = (right - left) / 3;
            long mid1 = left + oneThird;
            long mid2 = right - oneThird;
            long cost1 = check(nums, cost, mid1);
            long cost2 = check(nums, cost, mid2);
            res = Math.min(res, Math.min(cost1, cost2));
            if (cost1 > cost2) {
                left = mid1 + 1;
            }else {
                right = mid2 - 1;
            }
        }
        return res;
    }
    
    long check(int[] nums, int[] cost, long val) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+= cost[i] * Math.abs(nums[i] - val);
        }
        return sum;
    }
}