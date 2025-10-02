class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();

        Set<String> ops = new HashSet<>();
        ops.addAll(Arrays.asList("+", "-", "*", "/"));

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (ops.contains(token)) {
                String s2 = stack.pop();
                String s1 = stack.pop();
                int val = operate(s1, s2, token);
                stack.push(String.valueOf(val));
            } else {
                stack.push(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    public int operate(String s1, String s2, String ops) {
        int val1 = Integer.valueOf(s1), val2 = Integer.valueOf(s2);
        if (ops.equals("+")) {
            return val1 + val2;
        } else if (ops.equals("-")) {
            return val1 - val2;
        } else if (ops.equals("*")) {
            return val1 * val2;
        } else {
            return val1 /val2;
        }
    }
}