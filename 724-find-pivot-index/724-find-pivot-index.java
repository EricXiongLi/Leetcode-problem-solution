class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int res = -1;
        //[0, 1, 8, 11, 17, 22, 28]
        for (int i = 1; i <= nums.length; i++) {
            if (prefixSum[i - 1] - prefixSum[0] == prefixSum[nums.length] - prefixSum[i]) {
                res = i - 1;
                return res;
            }
        }
        return res;
    }
}