class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int curEnd = 0, curFur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
           curFur = Math.max(nums[i] + i, curFur);
            if (curFur >= nums.length - 1) {
                return step + 1;
            }
            if (i == curEnd) {
                curEnd = curFur;
                step++;
            }
        }
        return 0;
    }
}