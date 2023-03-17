class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        int leftSum = 1, rightSum = 1;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int rightPos = n - 1 - i;
            leftSum *= nums[i];
            rightSum *= nums[rightPos];
            left[i] = leftSum;
            right[rightPos] = rightSum;
        }
        Arrays.fill(res, 1);
        for (int i = 0; i < n; i++) {
           if (i > 0) res[i] *= left[i - 1];
            if (i < n - 1) res[i] *= right[i + 1];
        }
        return res;
    }
}