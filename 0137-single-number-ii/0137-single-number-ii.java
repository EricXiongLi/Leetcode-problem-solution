class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i) & 1;
            }
        }
        
        for (int i = 0; i < 32; i++) {
            count[i] %= 3;
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (count[i] << i);
        }
        
        return res;
    }
}