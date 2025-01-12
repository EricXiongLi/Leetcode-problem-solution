class Solution {
    public long countSubarrays(int[] nums, long k) {
        long curSum = 0L;
        long res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            while (l <= r && curSum * (r - l + 1) >= k) {
                curSum -= nums[l];
                l++;
            }
            if (curSum * (r - l + 1) < k) {
                res += (r - l + 1);
            }
        }
        return res;
    }
}