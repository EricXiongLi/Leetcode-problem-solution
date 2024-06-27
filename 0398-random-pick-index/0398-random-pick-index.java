class Solution {
    Random random;
    int[] nums;
    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }
    
    public int pick(int target) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (random.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}

//tc: O(n)
//sc: O(1)

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */