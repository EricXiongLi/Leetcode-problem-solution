class Solution {
    public int singleNumber(int[] nums) {
        int[] bitMap = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitMap[i] += (num >> i) & 1;
            }
        }
        for (int i = 0; i < 32; i++) {
            bitMap[i] %= 3;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (bitMap[i] << i);
        }
        return res;
    }
}