class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Deque<int[]> stack = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= nums[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek()[1];
            }
            
            stack.push(new int[]{nums[i], i});
        }
        
        stack.clear();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= nums[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek()[1];
            }
            stack.push(new int[]{nums[i], i});
        }
        int res = -1;
        for (int i = 0; i < n; i++) {
            int length = right[i] - left[i] - 1;
            if ((double) threshold / length < nums[i]) {
                res = length;
            }
        }
        return res;
        
    }
}

//tc: O(n)
//sc: O(n)