class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        for (int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        return res;
    }
}