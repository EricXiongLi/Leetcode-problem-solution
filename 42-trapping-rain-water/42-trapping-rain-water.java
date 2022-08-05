class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = height[0], maxRight = height[n - 1];
        int res = 0;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (maxLeft <= maxRight) {
                int cur = maxLeft - height[left] > 0 ? maxLeft - height[left] : 0;
                res += cur;
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
                
            } else {
                int cur = maxRight - height[right] > 0 ? maxRight - height[right] : 0;
                res += cur;
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }
        return res;
    }
}