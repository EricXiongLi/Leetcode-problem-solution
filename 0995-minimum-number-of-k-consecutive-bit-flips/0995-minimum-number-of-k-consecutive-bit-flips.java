/*
 * @lc app=leetcode id=995 lang=java
 *
 * [995] Minimum Number of K Consecutive Bit Flips
 */

// @lc code=start
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int currentWindowFlips = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && nums[i - k] == 2) {
                currentWindowFlips--;
            }


            if ((nums[i] + currentWindowFlips)%2 == 0) {
                if (i + k - 1 >= nums.length) {
                    return -1;
                } else {
                    currentWindowFlips++;
                    res++;
                    nums[i] = 2;
                }
            }

            
        }
        return res;
    }
}
// @lc code=end

