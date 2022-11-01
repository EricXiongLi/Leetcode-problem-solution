class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                int x = stack.pop();
                int y = stack.pop();
                int res = operate(y, s, x);
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
    
    boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    int operate(int x, String s, int y) {
        if (s.equals("+")) return x + y;
        if (s.equals("-")) return x - y;
        if (s.equals("*")) return x * y;
        if (s.equals("/")) return x / y;
        return 0;
    }
}