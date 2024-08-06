class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int n = nums.length;
        int count = 0;
        int res = 0;
        for (int end = 0; end < n; end++) {
            if (nums[end] == 0) {
                count++;
            }
            while (count >= 2) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res - 1;
    }
}