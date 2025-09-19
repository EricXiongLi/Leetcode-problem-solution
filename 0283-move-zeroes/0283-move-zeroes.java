class Solution {
    public void moveZeroes(int[] nums) {
        //nums[ < p]: non zero
        int p = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                swap(nums, i, p);
                p++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}