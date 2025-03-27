class Solution {
    public String removeStars(String s) {
        ArrayDeque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c != '*') {
                dq.push(c);
            } else {
                if (!dq.isEmpty()) {
                    dq.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
        }

        return sb.toString();
    }
}