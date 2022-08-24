class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int cur = Math.min(height[r], height[l]) * (r - l);
            res = Math.max(res, cur);
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}