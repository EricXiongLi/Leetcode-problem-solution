class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (i + 1 < n && nums[i + 1] == nums[i]) {
                i++;
            }
            nums[p] = nums[i];
            p++;
        }
        //1, 1, 2
        //p, i

        //.  p
        return p;
    }
}