class Solution {
    public int maxSubArray(int[] nums) {
        return maxSum(nums, 0, nums.length - 1);
    }
    
    int maxSum(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = l + r >> 1;
        int leftMax = maxSum(nums, l, mid);
        int rightMax = maxSum(nums, mid + 1, r);
        int crossingSum = crossSum(nums, l, r, mid);
        return Math.max(leftMax, Math.max(rightMax, crossingSum));
    }
    
    int crossSum(int[] nums, int l, int r, int mid) {
        int left = max1(nums, l, mid);
        int right = max2(nums, mid + 1, r);
        return left + right;
    }
    
    int max1(int[] nums, int l, int mid) {
        int res = nums[mid];
        int sum = 0;
        for (int i = mid; i >= l; i--) {
            sum += nums[i];
            res = Math.max(sum, res);
            
        }
        return res;
    }
    
    int max2(int[] nums, int mid, int r) {
        int res = nums[mid], sum = 0;
        for (int i = mid; i <= r; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }
    
    
    
    
}