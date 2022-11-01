class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty() ||stack.peek()  != '(') return false;
                else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() ||stack.peek() != '{') return false;
                else stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}