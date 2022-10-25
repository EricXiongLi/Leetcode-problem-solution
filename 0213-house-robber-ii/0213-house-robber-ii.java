class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int rob1 = rob(nums, 0, n - 2);
        int rob2 = rob(nums, 1, n - 1);
        return Math.max(rob1, rob2);
    }
    
    int rob(int[] nums, int l, int r) {
        int prev1 = 0;
        int prev2 = 0;
        int cur = 0;
        for (int i = r; i >= l; i--) {
            cur = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}

//tc: O(n)
//sc: O(n)
