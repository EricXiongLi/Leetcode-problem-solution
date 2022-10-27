class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int curSum = nums[l] + nums[r];
            if (curSum == target) {
                return new int[]{l + 1, r + 1};
            } else if (curSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[0];
    }
}