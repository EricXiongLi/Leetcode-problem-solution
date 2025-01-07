class Solution {
    public int maxArea(int[] height) {
        int p0 = 0, p1 = height.length - 1;
        int res = Integer.MIN_VALUE;
        while (p0 < p1) {
            res = Math.max(res, Math.min(height[p0], height[p1]) * (p1 - p0));
            if (height[p0] <= height[p1]) {
                p0++;
            } else {
                p1--;
            }
        }

        return res;
    }
}

//tc: O(n)
//sc: O(n)