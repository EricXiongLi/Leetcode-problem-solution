class Solution {
    public int missingElement(int[] nums, int k) {
        //[3,2,1]
        // nums[i] - nums[0] - 1 - (i - 1)
        // nums[i] - nums[0] - i
        int l = 0, r = nums.length - 1;
        //[l, mid - 1], [mid, r]
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (nums[m] - nums[0] - m >= k) {
                r = m - 1;
            } else{
                l = m;
            }
        }
        
        return nums[0] + l + k;
        //4, 7, 9, 10
        //l, m  l   r
        //      m
        // anwser - nums[0] + 1 = l + 1 + k
        // anwser = nums[0] + l + k
    }
}