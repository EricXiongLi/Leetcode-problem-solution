class Solution {
    public int wiggleMaxLength(int[] nums) {
        int down = 1;
        int up = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
            res = Math.max(down, up);
        }
        
        return res;
    }
}

//tc: O(n)
//sc: O(1)