class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //decreasing stack
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int peek = stack.pop();
                res[peek] = i - peek;
            }

            stack.push(i);
        }

        return res;
    }
}