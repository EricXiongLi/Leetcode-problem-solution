class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        int max = nums[0];
        int diff = max - nums[1];
        
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max, nums[i - 2]);
            diff = Math.max(max - nums[i - 1], diff);
            res = Math.max(nums[i] * (long)diff, res);
            
        }

        return res;
    }
}