class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], rightMax = nums[n - 1];
        int left = 1, right = n - 2;
        int res = 0;
        while (left <= right) {
            if (nums[left] >= leftMax) {
                leftMax = nums[left];
                left++;
            } else {
                if (rightMax >= leftMax) {
                    res += leftMax - nums[left];
                    left++;
                } else {
                    //rightMax < leftMax
                    if (nums[right] >= rightMax) {
                        rightMax = nums[right];
                        right--;
                    } else {
                        //nums[right] < rightMax < leftMax
                        res += rightMax - nums[right];
                        right--;
                    }
                }
            }
        }
        return res;
    }
}