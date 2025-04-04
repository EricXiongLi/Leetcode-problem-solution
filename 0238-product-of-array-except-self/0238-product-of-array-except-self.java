class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        //res[i] : the product n0, n1, n2... n(i-1)
        //res[i] = res[i - 1] * nums[i - 1];

        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int prefixProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            prefixProduct *= nums[i + 1];
            res[i] *= prefixProduct;
        }

        return res;
    }
}