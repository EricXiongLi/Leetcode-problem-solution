class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, i - stack.peek());
                stack.pop();
            }
        }

        return res;
    }
}