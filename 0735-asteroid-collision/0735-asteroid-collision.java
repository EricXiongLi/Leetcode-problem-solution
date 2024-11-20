class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (ast < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < ast * -1) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(ast);
                } else if (stack.peek() < 0) {
                    stack.push(ast);
                } else if (Math.abs(stack.peek()) == -ast) {
                    stack.pop();
                }
            } else {
                stack.push(ast);
            }
        }
        int sz = stack.size();
        int[] res = new int[sz];
        for (int i = 0; i < sz; i++) {
            res[i] = stack.pollLast();
        }
        return res;
        
    }
}