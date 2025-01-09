class Solution {
    public int removeDuplicates(int[] nums) {
        int pivot = 0;
        int i = 0;
        while (i < nums.length) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            int tmp = nums[pivot];
            nums[pivot] = nums[i];
            nums[i] = tmp;
            pivot++;
            i++;
        }
        return pivot;
    }
}