class Solution {
    public int removeElement(int[] nums, int val) {
        int p1 = 0;
        for (int p2 = 0; p2 < nums.length; p2++) {
            if (nums[p2] != val) {
                int tmp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = tmp;
                p1++;
            }
        }
        return p1;
    }
}