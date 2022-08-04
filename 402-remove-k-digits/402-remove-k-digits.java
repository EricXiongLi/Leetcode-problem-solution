class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            int c = Character.getNumericValue(num.charAt(i));
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        if (k > 0) {
            for (int i = 0; i < k; i++) {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() >= 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}