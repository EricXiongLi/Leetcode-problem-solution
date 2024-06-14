class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        //[l, m], [m + 1, r]
        while (l < r) {
            int m = l + r >> 1;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        if (r >= 0 && r < nums.length && nums[r] == target) {
            return r;
        } else {
            return -1;
        }
        
        
    }
}