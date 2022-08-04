class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastVisited = new int[123];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            lastVisited[c] = i;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (used.contains(c)) continue;
            while (!stack.isEmpty() && stack.peek() > c && lastVisited[stack.peek()] > i - 1) {
                used.remove(stack.peek());
                stack.pop();
            }
            
            used.add(c);
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int c = stack.pop();
            sb.append((char) c);
        }
        return sb.reverse().toString();
}
}