class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        int curZero = 0;
        int res = Integer.MIN_VALUE;
        while (right < n) {
            if (nums[right] == 0) {
                curZero++;
            }
            while (curZero > k) {
                if (nums[left] == 0) {
                    curZero--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}