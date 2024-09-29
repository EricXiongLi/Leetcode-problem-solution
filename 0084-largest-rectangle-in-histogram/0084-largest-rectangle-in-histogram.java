class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //keep an sbsolute increasing stack
        //[value, index]
        Deque<int[]> stack = new ArrayDeque<>();
        //the first left side less value's index
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek()[1];
            }
            stack.push(new int[]{heights[i], i});
        }
        
        stack.clear();
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek()[1];
            }
            stack.push(new int[]{heights[i], i});
        }
        
        int res = 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        for (int i = 0; i < n; i++) {
            res = Math.max(heights[i] * (right[i] - left[i] - 1), res);
        }
        
        return res;
    }
}