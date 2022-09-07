class Solution {
    public boolean isValid(String s) {
        //(): -1, 1   []: -2, 2, {}: -3, 3
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int curVal = getVal(cur);
            if (!stack.isEmpty() && stack.peek() < 0 && stack.peek() + curVal == 0) {
                stack.pop();
            } else {
                stack.push(curVal);
            }
        }
        return stack.isEmpty();
    }
    
    public int getVal(char c) {
        if (c == '(') return -1;
        else if (c == ')') return 1;
        else if (c == '[') return -2;
        else if (c == ']') return 2;
        else if (c == '{') return -3;
        else {
            return 3;
        }
    }
}