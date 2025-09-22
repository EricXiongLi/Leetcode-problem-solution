class Solution {
    public int scoreOfParentheses(String s) {
        Map<Integer, Integer> brackets = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                brackets.put(stack.pop(), i);
            }
        }
        return score(s, 0, s.length() - 1, brackets);
    }

    public int score(String s, int start, int end, Map<Integer, Integer> brackets) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int closedIndex = brackets.get(i);
                if (closedIndex - 1 == i) {
                    res += 1;
                    i++;
                } else {
                    res += 2 * score(s, i + 1, closedIndex - 1, brackets);
                    i = closedIndex;
                }
            }
        }

        return res;
    }
}