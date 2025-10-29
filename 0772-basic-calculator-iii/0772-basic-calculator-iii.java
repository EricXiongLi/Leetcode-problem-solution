class Solution {
    int idx = 0;

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char op = '+';
        int num = 0;
        while (idx < s.length()) {
            char ch = s.charAt(idx++);
            if (ch >= '0' && ch <= '9') {
                num = 10 * num + (ch - '0'); 
            }
            if (ch == '(') {
                num = calculate(s);
            }
            if (idx == s.length() || ch == '-' || ch == '+' || ch == '*' || ch == '/' || ch == ')') {
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
            
            if (ch == ')') {
                break;
            }
        }

        return stack.stream().mapToInt(i -> i).sum();
    }
}