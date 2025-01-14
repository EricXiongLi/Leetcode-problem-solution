class Solution {
    public void duplicateZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) count++;
        }
        int n = nums.length;
        int i = n - 1;
        int write = n - 1 + count;
        while (i >= 0 && write >= 0) {
            if (nums[i] != 0) {
                if (write < n) {
                    nums[write] = nums[i];
                }
                i--;
                write--;
            } else {
                if (write < n) {
                    nums[write] = 0;
                }
                write--;
                if (write < n) {
                    nums[write] = 0;
                }
                i--;
                write--;
            }
        }
    }
}