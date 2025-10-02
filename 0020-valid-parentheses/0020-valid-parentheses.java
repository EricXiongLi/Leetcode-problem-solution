class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
                if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (c == ']' && !stack.isEmpty() && stack.peek() == 
                '[') {
                    stack.pop();
                } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            
        }

        return stack.isEmpty();
    }
}