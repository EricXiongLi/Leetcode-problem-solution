class Solution {
    public String smallestSubsequence(String s) {
        Set<Integer> used = new HashSet<>();
        int[] lastVisited = new int[123];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            lastVisited[s.charAt(i)] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (used.contains(c)) continue;
            while (!stack.isEmpty() && stack.peek() > c && lastVisited[stack.peek()] > i - 1) {
                int p = stack.pop();
                used.remove(p);
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