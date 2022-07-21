class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, product = 1; i < n; i++) {
            ans[i] = product;
            product *= nums[i];
        }
        
        for (int i = n - 1, product = 1; i >= 0; i--) {
            ans[i] *= product;
            product *= nums[i];
        }
        
        return ans;
    }
}

//tc: O(n)
//sc: O(1)