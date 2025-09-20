class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int l = 0, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if ((m - 1 < 0 || nums[m - 1] != nums[m]) && (m + 1 >= n || nums[m + 1] != nums[m])) {
                return nums[m];
            }

            //1, 1, 2, 3, 3, 4, 4, 8, 8
            //l,          m           r
            //   

            //1, 2, 2
            //l, m, r
            //lr
            int leftSize = (m - 1 < 0 || nums[m - 1] == nums[m]) ? m - 2 - 0 + 1 : m - 1 - 0 + 1;
            if (leftSize % 2 == 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}