class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexToRemove = new HashSet<>();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}