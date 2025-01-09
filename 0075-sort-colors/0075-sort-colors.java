class Solution {
    public void sortColors(int[] nums) {
        //position to insert 0
        int left = 0, right = nums.length - 1;
        int idx = 0;
        while (idx <= right) {
            if (nums[idx] == 0) {
                swap(nums, idx, left);
                left++;
                idx++;
            } else if (nums[idx] == 2) {
                swap(nums, idx, right);
                right--;
            } else {
                idx++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp; 
    }
}