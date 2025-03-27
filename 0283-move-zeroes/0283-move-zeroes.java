class Solution {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        for (int p2 = 0; p2 < nums.length; p2++) {
            if (nums[p2] != 0) {
                nums[p1] = nums[p2];
                p1++;
            }
        }

        while (p1 < nums.length) {
            nums[p1++] = 0;
        }
    }
}