class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // decreasing stack
        Deque<Integer> stack = new ArrayDeque<>();
        int n= temperatures.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int top = stack.pop();
                res[top] = i - top;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            res[stack.pop()] = 0;
        }
        return res;
    }
}