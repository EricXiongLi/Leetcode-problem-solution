class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] dummy = nums.clone();
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int left = 0, right = 0;
        while (l < r) {
            left = nums[l];
            right = nums[r];
            if (left + right > target) {
                r--;
            } else if (left + right < target) {
                l++;
            } else {
                break;
            }
        }
        int[] res = new int[2];
        for (int i = 0; i < dummy.length; i++) {
            if (dummy[i] == left) {
                res[0] = i;
                break;
            }
        }
        for (int i = dummy.length - 1; i >= 0; i--) {
            if (dummy[i] == right) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
}