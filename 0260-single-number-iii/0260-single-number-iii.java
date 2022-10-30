class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int group = sum & (-sum);
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & group) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}