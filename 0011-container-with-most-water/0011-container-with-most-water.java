class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int res = Integer.MIN_VALUE;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            res = Math.max(res, min * (r - l));
            if (height[r] > height[l]) l++;
            else r--;
        }
        return res;
    }
}