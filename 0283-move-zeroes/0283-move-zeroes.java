class Solution {
    public void moveZeroes(int[] nums) {
        int firstZeroPoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, firstZeroPoint);
                firstZeroPoint++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//tc: O(n)
//sc: O(1)