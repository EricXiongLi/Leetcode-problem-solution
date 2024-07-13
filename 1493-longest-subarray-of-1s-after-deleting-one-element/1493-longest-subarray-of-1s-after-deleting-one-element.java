class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int zeroNum = 0;
        int res = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
               zeroNum++; 
            }
            
            while (zeroNum > 1) {
                if (nums[start] == 0) {
                    zeroNum--;
                }
                start++;
            }
            
            res = Math.max(res, end - start + 1);
        }
        
        return res - 1;
    }
}