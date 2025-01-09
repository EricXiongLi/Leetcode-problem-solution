class Solution {
    public int removeDuplicates(int[] nums) {
        int pivot = 0;
        int i = 0;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                swap(nums, i, pivot);
                pivot++;
                i++;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
            swap(nums, i, pivot);
            pivot++;
            i++;
        }

        return pivot;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}