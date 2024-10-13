class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                //(()
                //pij
                //j - p
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - (stack.isEmpty() ? -1 : stack.peek()));
                } else {
                    stack.push(i);
                } 
            }
        }
        
        return res;
    }
}