class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count1++;
            }
        }
        int curCount1 = 0;
        int start = 0;
        int res = Integer.MAX_VALUE;
        for (int end = 0; end < n + count1 - 1; end++) {
            while (end - start + 1 > count1) {
                curCount1 -= nums[start];
                start++;
            }
            curCount1 += nums[end % n];
            if (end - start + 1 == count1) {
                res = Math.min(count1 - curCount1, res);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}