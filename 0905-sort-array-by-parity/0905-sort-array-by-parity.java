class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int p0 = 0, p1 = nums.length - 1;
        //[0, p0 - 1]: even
        //[p1 + 1, n - 1]: odd
        //[i, p1]: unhandled
        int i = 0;
        while (p0 < p1 && i < nums.length) {
            if (nums[i] % 2 == 0) {
                swap(nums, i, p0);
                p0++;
                i++;
            } else {
                swap(nums, i, p1);
                p1--;
            }
        }
        return nums;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}