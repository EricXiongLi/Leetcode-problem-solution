class Solution {
    public int minOperations(int[] nums) {
        //0, 1, 1, 1,, 0,0
        //1, 0, 0, 1, 0, 0
        //1, 1, 1, 0, 0, 0
        //1
        int n = nums.length;
        int start = 0;
        int count = 0;
        for (int end = 0; end < n; end++) {
            while (end - start + 1 > 3) {
                start++;
            }
            if (end - start + 1 == 3) {
                if (nums[start] == 0) {
                    for (int i = 0; i < 3; i++) {
                        nums[start + i] = nums[start + i] == 0 ? 1 : 0;
                    }
                    count++;
                    start++;
                }
            }
        }
        
        if (nums[n - 1] == 0 || nums[n - 2] == 0) {
            return -1;
        }
        
        return count;
    }
}