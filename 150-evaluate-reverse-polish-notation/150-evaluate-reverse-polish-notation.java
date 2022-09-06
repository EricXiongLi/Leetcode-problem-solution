class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if (!isOperator(s)) {
                int num = Integer.valueOf(s);
                stack.push(num);
            } else {
                int firstNum = stack.pop();
                int secondNum = stack.pop();
                int res = calculate(secondNum, s, firstNum);
                stack.push(res);
            }
        }
        return stack.pop();
    }
    
    public boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
    
    public int calculate(int i, String s, int j) {
        if (s.equals("+")) {
            return i + j;
        } else if (s.equals("-")) {
            return i - j;
        } else if (s.equals("*")) {
            return i * j;
        } else {
            return i / j;
        }
    }
}