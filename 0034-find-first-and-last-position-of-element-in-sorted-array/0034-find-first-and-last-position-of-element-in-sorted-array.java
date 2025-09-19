class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }
    //<, >=
    public int findFirst(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public int findLast(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        if (r < 0) return -1;
        //<=, >
        while (l <= r) {
            int m = l + (r - l)/2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        if (r == -1) return -1;
        return nums[r] == target ? r : -1;
        //0, 0
        //l, r
        //m
        //.  lr
    }
}