class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int l1 = 0, l2 = 0;
        int n = nums.length;
        int sum = 0;
        int res = 0;
        int s1 = 0, s2 = 0;
        for (int r = 0; r < n; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (s1 > goal && l1 <= r) {
                s1 -= nums[l1];
                l1++;
            }
            while (s2 >= goal && l2 <= r) {
                s2 -= nums[l2];
                l2++;
            }
            res += (l2 - l1);
        }
        return res;
    }
}