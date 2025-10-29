class Solution {
    int idx = 0;
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char op = '+';

        while (idx < s.length()) {
            char ch = s.charAt(idx++);
            if (ch >= '0' && ch <= '9') {
                num = 10 * num + (ch - '0');
            }

            if (idx == s.length() || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }

                op = ch;
                num = 0;
            }

        }

        return stack.stream().mapToInt(i -> i).sum();
    }
}